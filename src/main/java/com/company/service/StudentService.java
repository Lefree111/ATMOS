package com.company.service;

import com.company.dto.mail.MailDTO;
import com.company.dto.student.StudentDTO;
import com.company.entity.mail.SendMailEntity;
import com.company.entity.student.StudentEntity;
import com.company.enums.StudentStatus;
import com.company.exp.ItemNotFoundExseption;
import com.company.exp.StatusNotActiveExseption;
import com.company.exp.StudentAlreadyCreatedExseption;
import com.company.exp.StudentStatusChangeExseption;
import com.company.repository.SendMailRepository;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private SendMailRepository sendMailRepository;


    //TODO create finish chack on
    public StudentDTO create(StudentDTO dto) {
        Optional<StudentEntity> optional1 = studentRepository.findByEmail(dto.getEmail());
        if (optional1.isPresent()) {
            throw new StudentAlreadyCreatedExseption("student ro'yxardan o'tgan !!!");
        }

        Optional<StudentEntity> optional2 = studentRepository.findByPhone(dto.getPhone());
        if (optional2.isPresent()) {
            throw new StudentAlreadyCreatedExseption("student ro'yxardan o'tgan !!!");
        }
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setBalance(dto.getBalance());
        entity.setStatus(StudentStatus.read);
        entity.setCreateDate(LocalDateTime.now());
        studentRepository.save(entity);
        dto.setId(entity.getId());
        return toDTO(entity);
    }

    //TODO getById finish chack on
    public StudentDTO getById(Integer phone) {
        Optional<StudentEntity> optional = studentRepository.findByPhone(phone);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("student not found");
        }
        if (optional.get().getStatus().equals(StudentStatus.no_read)){
            throw new StatusNotActiveExseption("Status not active");
        }
        return toDTO(optional.get());
    }

    //TODO update finish chack on
    public StudentDTO update(StudentDTO dto, Integer phone) {
        Optional<StudentEntity> optional = studentRepository.findByPhone(phone);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("student not found");
        }
        Optional<StudentEntity> optional1 = studentRepository.findByEmail(dto.getEmail());
        if (optional1.isPresent()) {
            throw new StudentAlreadyCreatedExseption("student ro'yxardan o'tgan !!!");
        }
        StudentEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUpdateDate(LocalDateTime.now());
        studentRepository.save(entity);
        dto.setId(entity.getId());
        return toDTO(entity);

    }

    //TODO delete finish chack on
    public void delete(Integer phone) {
        Optional<StudentEntity> optional = studentRepository.findByPhone(phone);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("student not found");
        }
        studentRepository.delete(optional.get());
    }

    //TODO updateStudentstatus chack on
    public Boolean updateStudentStatus(Integer phone) {
        Optional<StudentEntity> optional = studentRepository.findByPhone(phone);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("student not found");
        }
        if (optional.get().getStatus().equals(StudentStatus.no_read)) {
            throw new StudentStatusChangeExseption("status active emas");
        }
        int n = studentRepository.updateStatus(StudentStatus.no_read, phone);
        return n > 0;
    }

    //TODO sendMessage finish chack on
    public void sendMessage(String to) {

        Optional<StudentEntity> entity = studentRepository.findByEmail(to);
        if (entity.isPresent() && entity.get().getStatus().equals(StudentStatus.read)) {
            MailDTO mail = new MailDTO();
            mail.setFrom("lefree111@mail.ru");
            mail.setTo(to);
            mail.setSubject("Welcome ATMOS traning center");
            mail.setContent("Your Password: " + entity.get().getPassword());
            emailService.sendSimpleMessage(mail);
            SendMailEntity sendMail = new SendMailEntity();
            sendMail.setFromAccount("lefree111@mail.ru");
            sendMail.setToAccount(to);
            sendMail.setContent("Your Password: " + entity.get().getPassword());
            sendMail.setSubject("Welcome ATMOS traning center");
            sendMail.setName(entity.get().getName());
            sendMail.setSurname(entity.get().getSurname());
            sendMail.setUsername(entity.get().getUsername());
            sendMail.setSendMailDate(LocalDateTime.now());
            sendMailRepository.save(sendMail);
        } else {
            throw new ItemNotFoundExseption("Student not found");
        }
    }

    public StudentDTO toDTO(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());
        dto.setStatus(entity.getStatus());
        dto.setBalance(entity.getBalance());
        dto.setCreateDate(entity.getCreateDate());
        dto.setUpdateDate(entity.getUpdateDate());
        return dto;
    }
}
