use examinationportal

CREATE TABLE `Users` (
  `id` bigint(20) NOT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mobile` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `c_by` bigint(20) NOT NULL,
  `c_at` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `u_by` bigint(20) NOT NULL,
  `u_at` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `Users` (`id`, `full_name`, `dob`, `password`, `email`, `mobile`, `status`, `c_by`, `c_at`, `u_by`, `u_at`) VALUES
(1, 'Ashish Gaikwad', '07/09/1997', 'Ashish@1997', 'ashishgaikwad1997@gmail.com', '8976834278', 1, 0, '', 0, '');


ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `Users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;


CREATE TABLE `screens` (
  `screen_id` bigint(20) NOT NULL,
  `screen_name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `screen_url` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `screen_parent` bigint(20) NOT NULL,
  `screen_menu_level` int(11) NOT NULL,
  `rowstate` int(11) NOT NULL,
  `screen_icon` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;




INSERT INTO `screens` (`screen_id`, `screen_name`, `screen_url`, `screen_parent`, `screen_menu_level`, `rowstate`, `screen_icon`) VALUES
(8, 'Administrative Tools', '#', 0, 0, 1, 'fa fa-users'),
(9, 'Screen Management', 'administrative_tools/ScreenManagement.jsp', 8, 0, 1, ''),
(10, 'Role Management', 'administrative_tools/RoleManagement.jsp', 8, 0, 1, ''),
(11, 'User Management', 'administrative_tools/UserManagement.jsp', 8, 0, 1, '');


ALTER TABLE `screens`
  ADD PRIMARY KEY (`screen_id`);


ALTER TABLE `screens`
  MODIFY `screen_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;



CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role_state` int(11) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_at` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_by` bigint(20) NOT NULL,
  `updated_at` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO `role` (`role_id`, `role_name`, `role_state`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 'ADMIN', 1, 1, '2019-10-28 11:11:11.222', 1, '2019-10-28 11:11:11.222');


ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);


ALTER TABLE `role`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;




CREATE TABLE `users_role_mapping` (
  `id` bigint(20) NOT NULL,
  `u_id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  `rowstate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `users_role_mapping` (`id`, `u_id`, `r_id`, `rowstate`) VALUES
(1, 1, 1, 1);


ALTER TABLE `users_role_mapping`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `users_role_mapping`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;




CREATE TABLE `role_screen_mapping` (
  `id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  `s_id` bigint(20) NOT NULL,
  `rowstate` int(11) NOT NULL,
  `RWUD` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO `role_screen_mapping` (`id`, `r_id`, `s_id`, `rowstate`, `RWUD`) VALUES
(54, 1, 8, 1, '1~1~1~1'),
(55, 1, 9, 1, '1~1~1~1'),
(56, 1, 10, 1, '1~1~1~1'),
(57, 1, 11, 1, '1~1~1~1');

ALTER TABLE `role_screen_mapping`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FOREIGN R_R` (`r_id`),
  ADD KEY `FOREIGN R_S` (`s_id`);


ALTER TABLE `role_screen_mapping`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;



ALTER TABLE `role_screen_mapping`
  ADD CONSTRAINT `FOREIGN R_R` FOREIGN KEY (`r_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FOREIGN R_S` FOREIGN KEY (`s_id`) REFERENCES `screens` (`screen_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;





CREATE  TABLE `examinationportal`.`subject` (
  `subject_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `subject_name` VARCHAR(45) NULL ,
  `subjectcode` VARCHAR(45) NULL ,
  `subject_head` BIGINT NULL ,
  `subject_admission_start_date` DATE NULL ,
  `subject_admission_end_date` DATE NULL ,
  `subject_examination_date` DATE NULL ,
  `subject_result_date` DATE NULL ,
  `subject_fee` BIGINT NULL ,
  `subject_description` MEDIUMTEXT NULL ,
  PRIMARY KEY (`subject_id`) );
  

  
 CREATE  TABLE `examinationportal`.`questions` (
  `questions_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `questions_subject_id` BIGINT NOT NULL ,
  `questions_question` VARCHAR(2000) NOT NULL ,
  `questions_options` MEDIUMTEXT NOT NULL ,
  `questions_correct_option` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`questions_id`) ,
  INDEX `question_subject_idx` (`questions_subject_id` ASC) ,
  CONSTRAINT `question_subject`
    FOREIGN KEY (`questions_subject_id` )
    REFERENCES `examinationportal`.`subject` (`subject_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


ALTER TABLE `examinationportal`.`questions` ADD COLUMN `questions_marks` BIGINT NOT NULL  AFTER `questions_correct_option` ;
ALTER TABLE `examinationportal`.`questions` CHANGE COLUMN `questions_correct_option` `questions_correct_option` INT NOT NULL  ;

CREATE  TABLE `examinationportal`.`examination` (
  `eId` BIGINT NOT NULL AUTO_INCREMENT ,
  `eTitle` VARCHAR(500) NULL ,
  `eSubjectId` BIGINT NULL ,
  `eMarkQueDetails` MEDIUMTEXT NULL ,
  `eTotalQue` BIGINT NULL ,
  `eTotalMarks` BIGINT NULL ,
  `ePassingMarks` BIGINT NULL ,
  `eDuration` BIGINT NULL ,
  `eDescription` MEDIUMTEXT NULL ,
  `eAdmissionStartDate` VARCHAR(100) NULL ,
  `eAdmissionLastDate` VARCHAR(100) NULL ,
  `eHallTicketDate` VARCHAR(100) NULL ,
  `eDate` VARCHAR(100) NULL ,
  `eResultDate` VARCHAR(100) NULL ,
  `eFee` BIGINT NULL ,
  `eIsActive` INT NULL ,
  PRIMARY KEY (`eId`) );


