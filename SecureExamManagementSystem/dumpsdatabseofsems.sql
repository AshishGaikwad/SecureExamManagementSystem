-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: examinationportal
-- ------------------------------------------------------
-- Server version	5.6.45-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer_sheet`
--

DROP TABLE IF EXISTS `answer_sheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer_sheet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `q_id` bigint(20) DEFAULT NULL,
  `e_id` bigint(20) DEFAULT NULL,
  `u_id` bigint(20) DEFAULT NULL,
  `er_id` bigint(20) DEFAULT NULL,
  `selected_option` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_sheet`
--

LOCK TABLES `answer_sheet` WRITE;
/*!40000 ALTER TABLE `answer_sheet` DISABLE KEYS */;
INSERT INTO `answer_sheet` VALUES (1,49,3,9,6,2),(2,50,3,9,6,4),(3,51,3,9,6,2),(4,54,3,9,6,3),(5,23,3,9,6,2),(6,55,3,9,6,2),(7,59,3,9,6,4),(8,44,3,9,6,4),(9,60,3,9,6,3),(10,45,3,9,6,1),(11,1,1,9,7,2),(12,34,1,9,7,1),(13,35,1,9,7,4),(14,39,1,9,7,1),(15,24,1,9,7,3),(16,25,1,9,7,4),(17,29,1,9,7,3),(18,30,1,9,7,4);
/*!40000 ALTER TABLE `answer_sheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examination` (
  `eId` bigint(20) NOT NULL AUTO_INCREMENT,
  `eTitle` varchar(500) DEFAULT NULL,
  `eSubjectId` bigint(20) DEFAULT NULL,
  `eMarkQueDetails` mediumtext,
  `eTotalQue` bigint(20) DEFAULT NULL,
  `eTotalMarks` bigint(20) DEFAULT NULL,
  `ePassingMarks` bigint(20) DEFAULT NULL,
  `eDuration` bigint(20) DEFAULT NULL,
  `eDescription` mediumtext,
  `eAdmissionStartDate` varchar(100) DEFAULT NULL,
  `eAdmissionLastDate` varchar(100) DEFAULT NULL,
  `eHallTicketDate` varchar(100) DEFAULT NULL,
  `eDate` varchar(100) DEFAULT NULL,
  `eResultDate` varchar(100) DEFAULT NULL,
  `eFee` bigint(20) DEFAULT NULL,
  `eIsActive` int(11) DEFAULT NULL,
  PRIMARY KEY (`eId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination`
--

LOCK TABLES `examination` WRITE;
/*!40000 ALTER TABLE `examination` DISABLE KEYS */;
INSERT INTO `examination` VALUES (1,'[2020 SEM I] JAVA EXAMINATION ',7,'1=3,2=2,4=2,5=1',8,20,7,30,'<p style=\"margin-bottom: 1em; padding: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 17.3333px; line-height: inherit; font-family: Roboto, Arial, san-serif; vertical-align: baseline; color: rgb(0, 0, 0); background-color: rgb(247, 247, 247);\"><span style=\"margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline;\"><font color=\"red\">About AANPCB?s Practice Examinations:</font></span></p><ul style=\"margin-right: 0px; margin-bottom: 1em; margin-left: 30px; padding: 0px 0px 0px 30px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 17.3333px; line-height: inherit; font-family: Roboto, Arial, san-serif; vertical-align: baseline; list-style-position: inside; list-style-image: initial; text-indent: -30px; color: rgb(0, 0, 0); background-color: rgb(247, 247, 247);\"><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\"><span style=\"margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline;\">There are two versions of the Family practice test.</span></li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\"><span style=\"margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline;\">There is only one version of the Adult-Gerontology practice test.</span></li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\"><span style=\"margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline;\">There is currently no Emergency practice test</span></li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Both practice exams meet the same test examination specifications of AANPCB?s certification examinations.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Exam content is based on AANPCB?s test specifications (test blueprint), which may be found online and in the&nbsp;<a href=\"https://www.aanpcert.org/resource/documents/AGNP%20FNP%20Candidate%20Handbook.pdf\" target=\"_blank\" style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline; color: rgb(9, 73, 129); text-decoration-line: underline;\"><span style=\"margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline;\">Candidate Handbook</span></a>.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Each test consists of 75 multiple-choice items.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Questions were developed by NP content experts.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Questions test entry-level competencies.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Unlike the certification examination results, which are reported in scaled scores, Practice Exam Scores are reported in percentages.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Test scores are confidential and are not used for certification purposes.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">The cost of taking one Practice Examination is $50 USD.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Upon purchase, the test may be taken only once.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">The test may be purchased multiple times.</li><li style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">Continuing education (CE) hours&nbsp;<span style=\"margin: 0px; padding: 0px; border: 0px; font-style: inherit; font-variant: inherit; font-stretch: inherit; font-size: inherit; line-height: inherit; font-family: inherit; vertical-align: baseline;\"><u style=\"margin: 0px; padding: 0px; border: 0px; font: inherit; vertical-align: baseline;\">are not</u></span>&nbsp;awarded for completion of the Practice Exam.</li></ul>','10/03/2020','15/03/2020','16/03/2020','10/03/2020','18/03/2020',1000,1),(3,'[2020 SEM I] ECONOMICS EXAMINATION ',9,'1=3,2=3,3=2,5=2',10,25,11,45,'<p style=\"-webkit-tap-highlight-color: transparent; margin-top: 1.5em; margin-bottom: 1.5em; color: rgb(123, 136, 152); font-size: 1.1875em; font-family: &quot;Mercury SSm A&quot;, &quot;Mercury SSm B&quot;, Georgia, Times, &quot;Times New Roman&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, ????, ??, SimSun, STXihei, ????, serif; line-height: 1.5; animation: 1000ms linear 0s 1 normal none running fadeInLorem;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. A diam sollicitudin tempor id eu nisl nunc. Velit scelerisque in dictum non. Amet tellus cras adipiscing enim eu turpis egestas. Sed sed risus pretium quam vulputate dignissim suspendisse in est. Natoque penatibus et magnis dis parturient montes nascetur ridiculus mus. Arcu risus quis varius quam quisque. A iaculis at erat pellentesque adipiscing commodo. Non diam phasellus vestibulum lorem sed risus. Ultricies leo integer malesuada nunc vel risus commodo viverra maecenas. Sed velit dignissim sodales ut eu sem integer. Lectus proin nibh nisl condimentum. Habitant morbi tristique senectus et. Arcu non sodales neque sodales ut etiam. Neque egestas congue quisque egestas diam in. Amet venenatis urna cursus eget nunc scelerisque viverra mauris. Sed velit dignissim sodales ut eu sem integer. Ut etiam sit amet nisl. Elementum tempus egestas sed sed risus pretium quam. Pretium lectus quam id leo.</p><p style=\"-webkit-tap-highlight-color: transparent; margin-top: 1.5em; margin-bottom: 1.5em; color: rgb(123, 136, 152); font-size: 1.1875em; font-family: &quot;Mercury SSm A&quot;, &quot;Mercury SSm B&quot;, Georgia, Times, &quot;Times New Roman&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, ????, ??, SimSun, STXihei, ????, serif; line-height: 1.5; animation: 1000ms linear 0s 1 normal none running fadeInLorem;\">Nunc congue nisi vitae suscipit tellus mauris. Orci a scelerisque purus semper eget duis at tellus at. Id donec ultrices tincidunt arcu non sodales neque sodales. Facilisi etiam dignissim diam quis enim. Eget egestas purus viverra accumsan in nisl nisi scelerisque eu. Cursus eget nunc scelerisque viverra mauris in aliquam sem. Eu volutpat odio facilisis mauris sit amet. In aliquam sem fringilla ut morbi. Urna id volutpat lacus laoreet non curabitur gravida arcu ac. Et ultrices neque ornare aenean euismod elementum nisi. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi.</p><p style=\"-webkit-tap-highlight-color: transparent; margin-top: 1.5em; margin-bottom: 1.5em; color: rgb(123, 136, 152); font-size: 1.1875em; font-family: &quot;Mercury SSm A&quot;, &quot;Mercury SSm B&quot;, Georgia, Times, &quot;Times New Roman&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, ????, ??, SimSun, STXihei, ????, serif; line-height: 1.5; animation: 1000ms linear 0s 1 normal none running fadeInLorem;\">Dui vivamus arcu felis bibendum. Vivamus arcu felis bibendum ut tristique et egestas. Ac tortor dignissim convallis aenean. Eget magna fermentum iaculis eu non diam. Proin sed libero enim sed faucibus. Lorem ipsum dolor sit amet consectetur adipiscing elit. Gravida in fermentum et sollicitudin ac orci phasellus egestas tellus. Neque volutpat ac tincidunt vitae semper quis lectus nulla at. Gravida cum sociis natoque penatibus. Dis parturient montes nascetur ridiculus mus mauris vitae ultricies. Tortor posuere ac ut consequat semper. Integer enim neque volutpat ac tincidunt. Nunc vel risus commodo viverra maecenas. Gravida cum sociis natoque penatibus et magnis dis parturient. Tristique et egestas quis ipsum suspendisse ultrices. Justo nec ultrices dui sapien eget mi proin. Felis donec et odio pellentesque.</p><p style=\"-webkit-tap-highlight-color: transparent; margin-top: 1.5em; margin-bottom: 1.5em; color: rgb(123, 136, 152); font-size: 1.1875em; font-family: &quot;Mercury SSm A&quot;, &quot;Mercury SSm B&quot;, Georgia, Times, &quot;Times New Roman&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, ????, ??, SimSun, STXihei, ????, serif; line-height: 1.5; animation: 1000ms linear 0s 1 normal none running fadeInLorem;\">Risus feugiat in ante metus dictum at tempor commodo. In hendrerit gravida rutrum quisque non. Sed augue lacus viverra vitae congue. Sem et tortor consequat id porta nibh. Cras sed felis eget velit aliquet sagittis id. Purus ut faucibus pulvinar elementum integer enim neque. Diam donec adipiscing tristique risus nec. Maecenas ultricies mi eget mauris pharetra et ultrices neque. Lobortis mattis aliquam faucibus purus in massa. Justo eget magna fermentum iaculis eu non diam phasellus. Lectus vestibulum mattis ullamcorper velit sed. Nisl rhoncus mattis rhoncus urna. Risus viverra adipiscing at in tellus integer feugiat scelerisque varius. Est ullamcorper eget nulla facilisi etiam.</p><p style=\"-webkit-tap-highlight-color: transparent; margin-top: 1.5em; margin-bottom: 1.5em; color: rgb(123, 136, 152); font-size: 1.1875em; font-family: &quot;Mercury SSm A&quot;, &quot;Mercury SSm B&quot;, Georgia, Times, &quot;Times New Roman&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, ????, ??, SimSun, STXihei, ????, serif; line-height: 1.5; animation: 1000ms linear 0s 1 normal none running fadeInLorem;\">Lobortis mattis aliquam faucibus purus in massa tempor nec. Malesuada bibendum arcu vitae elementum curabitur vitae nunc. Amet nulla facilisi morbi tempus iaculis urna. Viverra aliquet eget sit amet tellus cras adipiscing enim. Amet volutpat consequat mauris nunc congue nisi vitae suscipit. Semper auctor neque vitae tempus quam. Iaculis urna id volutpat lacus laoreet non curabitur gravida arcu. Vitae sapien pellentesque habitant morbi tristique senectus et. Ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget. Magnis dis parturient montes nascetur ridiculus mus mauris vitae. Sagittis nisl rhoncus mattis rhoncus urna neque viverra justo nec. Ullamcorper eget nulla facilisi etiam. Elementum nisi quis eleifend quam adipiscing vitae proin sagittis nisl.</p>','28/02/2020','03/03/2020','03/03/2020','10/03/2020','06/03/2020',990,1);
/*!40000 ALTER TABLE `examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination_registration`
--

DROP TABLE IF EXISTS `examination_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examination_registration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eid` bigint(20) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `pid` varchar(300) DEFAULT NULL,
  `passcode` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination_registration`
--

LOCK TABLES `examination_registration` WRITE;
/*!40000 ALTER TABLE `examination_registration` DISABLE KEYS */;
INSERT INTO `examination_registration` VALUES (6,3,9,'BATU-9-1583252864952','','D~1583842881236'),(7,1,9,'BATU-9-1583844282372','','D~1583851486436');
/*!40000 ALTER TABLE `examination_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_order`
--

DROP TABLE IF EXISTS `payment_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_order` (
  `transactionId` varchar(300) NOT NULL,
  `id` varchar(200) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `payments` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`transactionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_order`
--

LOCK TABLES `payment_order` WRITE;
/*!40000 ALTER TABLE `payment_order` DISABLE KEYS */;
INSERT INTO `payment_order` VALUES ('BATU-9-1583164705220','f2ff777678bd41ebbe5e11c220b34478','completed','INR',1000,'[Payment{id=\'MOJO0302O05N10798258\', status=\'successful\'}]'),('BATU-9-1583251094056','3e3b8a206d7a42a1ac5e0e23fa5cf0ec','completed','INR',990,'[Payment{id=\'MOJO0303N05A12868298\', status=\'successful\'}]'),('BATU-9-1583252159862','c61c17d610af4cc4830ed9079e14145d','completed','INR',990,'[Payment{id=\'MOJO0303305N12868302\', status=\'successful\'}]'),('BATU-9-1583252318507','4565be528d7c446abd09eddd4861435a','completed','INR',990,'[Payment{id=\'MOJO0303105N12868303\', status=\'successful\'}]'),('BATU-9-1583252623460','003b5a3321644b4dbfde4a7757770306','completed','INR',990,'[Payment{id=\'MOJO0303N05N12868306\', status=\'successful\'}]'),('BATU-9-1583252864952','e3c47035cf9d4676a39c338ce27cefd7','completed','INR',990,'[Payment{id=\'MOJO0303P05N12868307\', status=\'successful\'}]'),('BATU-9-1583844282372','21c5098b56dd4afe97f7ff7e19b39273','completed','INR',1000,'[Payment{id=\'MOJO0310Q05N31075699\', status=\'successful\'}]');
/*!40000 ALTER TABLE `payment_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `questions_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `questions_subject_id` bigint(20) NOT NULL,
  `questions_question` varchar(2000) NOT NULL,
  `questions_options` mediumtext NOT NULL,
  `questions_correct_option` int(11) NOT NULL,
  `questions_marks` bigint(20) NOT NULL,
  PRIMARY KEY (`questions_id`),
  KEY `question_subject_idx` (`questions_subject_id`),
  CONSTRAINT `question_subject` FOREIGN KEY (`questions_subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,7,'Which of this keyword can be used in a subclass to call the constructor of superclass?','[{\"id\":1,\"value\":\"super\"},{\"id\":2,\"value\":\"this\"},{\"id\":3,\"value\":\"extent\"},{\"id\":4,\"value\":\"extends\"}]',1,1),(23,9,'what is economics?','[{\"id\":1,\"value\":\"enviroment study\"},{\"id\":2,\"value\":\"Financial Study\"},{\"id\":3,\"value\":\"Medical study\"},{\"id\":4,\"value\":\"None of the mentioned\"}]',2,1),(24,7,' An expression involving byte, int, and literal numbers is promoted to which of these?','[{\"id\":1,\"value\":\"int\"},{\"id\":2,\"value\":\" long\"},{\"id\":3,\"value\":\"byte\"},{\"id\":4,\"value\":\" float\"}]',1,1),(25,7,'Which data type value is returned by all transcendental math functions?','[{\"id\":1,\"value\":\" int\"},{\"id\":2,\"value\":\" long\"},{\"id\":3,\"value\":\"byte\"},{\"id\":4,\"value\":\" float\"}]',3,1),(26,7,'Which of these class is superclass of String and StringBuffer class?','[{\"id\":1,\"value\":\" java.util\"},{\"id\":2,\"value\":\" java.lang\"},{\"id\":3,\"value\":\"ArrayList\"},{\"id\":4,\"value\":\" None of the mentioned\"}]',2,1),(27,7,'Which of these operators can be used to concatenate two or more String objects?','[{\"id\":1,\"value\":\"+\"},{\"id\":2,\"value\":\"+=\"},{\"id\":3,\"value\":\"&\"},{\"id\":4,\"value\":\" ||\"}]',1,1),(28,7,'Which of these method of class String is used to obtain length of String object?','[{\"id\":1,\"value\":\" get()\"},{\"id\":2,\"value\":\"Sizeof()\"},{\"id\":3,\"value\":\"lengthof()\"},{\"id\":4,\"value\":\" length()\"}]',4,1),(29,7,'Which of these method of class String is used to extract a single character from a String object?','[{\"id\":1,\"value\":\"CHARAT()\"},{\"id\":2,\"value\":\"charat()\"},{\"id\":3,\"value\":\" charAt()\"},{\"id\":4,\"value\":\" ChatAt()\"}]',3,2),(30,7,' Which of these constructors is used to create an empty String object?','[{\"id\":1,\"value\":\"String()\"},{\"id\":2,\"value\":\"String(void)\"},{\"id\":3,\"value\":\"String(0)\"},{\"id\":4,\"value\":\"None of the mentioned\"}]',1,2),(31,7,'Which of these is used to perform all input & output operations in Java?','[{\"id\":1,\"value\":\"streams\"},{\"id\":2,\"value\":\"Variables\"},{\"id\":3,\"value\":\"classes\"},{\"id\":4,\"value\":\" Methods\"}]',1,2),(32,7,' What does AWT stands for?','[{\"id\":1,\"value\":\" All Window Tools\"},{\"id\":2,\"value\":\" All Writing Tools\"},{\"id\":3,\"value\":\" Abstract Window Toolkit\"},{\"id\":4,\"value\":\"Abstract Writing Toolkit\"}]',3,2),(33,7,'Which of these is a type of stream in Java?','[{\"id\":1,\"value\":\" Integer stream\"},{\"id\":2,\"value\":\" Short stream\"},{\"id\":3,\"value\":\"Byte stream\"},{\"id\":4,\"value\":\" Long stream\"}]',3,2),(34,7,'Which of these classes are used by Byte streams for input and output operation?','[{\"id\":1,\"value\":\"InputStream\"},{\"id\":2,\"value\":\"InputOutputStream\"},{\"id\":3,\"value\":\"Reader\"},{\"id\":4,\"value\":\"All of the mentioned\"}]',1,4),(35,7,' Which of these classes are used by character streams for input and output operations?','[{\"id\":1,\"value\":\"InputStream\"},{\"id\":2,\"value\":\"Writer\"},{\"id\":3,\"value\":\"ReadStream\"},{\"id\":4,\"value\":\"InputOutputStream\"}]',2,4),(36,7,'Which of these functions is called to display the output of an applet?','[{\"id\":1,\"value\":\" display()\"},{\"id\":2,\"value\":\"print()\"},{\"id\":3,\"value\":\"displayApplet()\"},{\"id\":4,\"value\":\"PrintApplet()\"}]',2,4),(37,7,'Which of these methods can be used to output a sting in an applet?','[{\"id\":1,\"value\":\" display()\"},{\"id\":2,\"value\":\"print()\"},{\"id\":3,\"value\":\" drawString()\"},{\"id\":4,\"value\":\"transient()\"}]',3,4),(38,7,'Which of these methods is a part of Abstract Window Toolkit (AWT) ?','[{\"id\":1,\"value\":\" display()\"},{\"id\":2,\"value\":\" print()\"},{\"id\":3,\"value\":\"drawString()\"},{\"id\":4,\"value\":\"transient()\"}]',2,4),(39,7,'Which of these modifiers can be used for a variable so that it can be accessed from any thread or parts of a program?','[{\"id\":1,\"value\":\"transient\"},{\"id\":2,\"value\":\"volatile\"},{\"id\":3,\"value\":\"global\"},{\"id\":4,\"value\":\"No modifier is needed\"}]',2,5),(40,7,'Which of these operators is used to allocate memory to array variable in Java?','[{\"id\":1,\"value\":\"malloc\"},{\"id\":2,\"value\":\" alloc\"},{\"id\":3,\"value\":\"new\"},{\"id\":4,\"value\":\"new malloc\"}]',3,5),(41,7,'Which of these is an incorrect array declaration?','[{\"id\":1,\"value\":\"int arr[] = new int[5]\"},{\"id\":2,\"value\":\" int [] arr = new int[5]\"},{\"id\":3,\"value\":\"int arr[]\"},{\"id\":4,\"value\":\" int arr[] = int [5] new\"}]',4,5),(42,7,'Which of these is necessary to specify at time of array initialization?','[{\"id\":1,\"value\":\"Row\"},{\"id\":2,\"value\":\"Column\"},{\"id\":3,\"value\":\"Both Row and Column\"},{\"id\":4,\"value\":\"None of the mentioned\"}]',1,5),(43,7,'Which of these packages contain all the collection classes?','[{\"id\":1,\"value\":\"java.lang\"},{\"id\":2,\"value\":\"java.util\"},{\"id\":3,\"value\":\" java.net\"},{\"id\":4,\"value\":\"java.awt\"}]',2,5),(44,9,'What do you mean by the supply of goods?','[{\"id\":1,\"value\":\"Stock available for sale\"},{\"id\":2,\"value\":\" Total stock in the warehouse\"},{\"id\":3,\"value\":\"The actual production of the good\"},{\"id\":4,\"value\":\"Quantity of the good offered for sale at a particular price per unit of time\"}]',4,1),(45,9,'What do you mean by under conditions of perfect competition in the product market?','[{\"id\":1,\"value\":\"MRP=VMP\"},{\"id\":2,\"value\":\" MRP>VMP\"},{\"id\":3,\"value\":\"VMP>MRP\"},{\"id\":4,\"value\":\"None of the above\"}]',1,1),(46,9,'The relation that the law of demand defines is.','[{\"id\":1,\"value\":\" Income and price of a commodity\"},{\"id\":2,\"value\":\"Price and quantity of a commodity\"},{\"id\":3,\"value\":\"Income and quantity demanded\"},{\"id\":4,\"value\":\" Quantity demanded and quantity supplied\"}]',2,1),(47,9,' What do you mean by a mixed economy?','[{\"id\":1,\"value\":\"Modern and traditional industries\"},{\"id\":2,\"value\":\") Public and private sectors\"},{\"id\":3,\"value\":\"Foreign and domestic investments\"},{\"id\":4,\"value\":\"Commercial and subsistence farming\"}]',4,1),(48,9,' What do you mean by demand of a commodity?','[{\"id\":1,\"value\":\" A desire for the commodity\"},{\"id\":2,\"value\":\" Need for the commodity\"},{\"id\":3,\"value\":\" Quantity demanded of that commodity\"},{\"id\":4,\"value\":\"Quantity of the commodity demanded at a certain price during any particular period of time\"}]',4,1),(49,9,'Starting from the time of Independence India followed a planned economy because.','[{\"id\":1,\"value\":\"Only 2\"},{\"id\":2,\"value\":\"2 and 3\"},{\"id\":3,\"value\":\"1 and 3\"},{\"id\":4,\"value\":\" All the above\"}]',2,2),(50,9,' What do you mean by Gross National Product?','[{\"id\":1,\"value\":\" The total value of goods and services produced in the country\"},{\"id\":2,\"value\":\"The total value of all transactions in the country\"},{\"id\":3,\"value\":\"Depreciation in the total value of goods and services produced in the country\"},{\"id\":4,\"value\":\"The total value of goods and services produced in the country and net factor income from abroad\"}]',4,2),(51,9,'The reason for the decline in the child sex ratio in India is.','[{\"id\":1,\"value\":\"Low fertility rate.\"},{\"id\":2,\"value\":\"Female foeticide\"},{\"id\":3,\"value\":\" Incentives for boy child from government\"},{\"id\":4,\"value\":\" None of the above\"}]',2,2),(52,9,' What things are taken into consideration while revising the poverty line periodically.','[{\"id\":1,\"value\":\"By conducting a survey every five years\"},{\"id\":2,\"value\":\"National Sample Survey Organisation carry out the survey\"},{\"id\":3,\"value\":\" Both a and b are taken into consideration\"},{\"id\":4,\"value\":\" None of the above\"}]',3,2),(53,9,'In India, which bank has the highest share in the disbursement of credit to agriculture and allied activities?','[{\"id\":1,\"value\":\"Cooperative Banks\"},{\"id\":2,\"value\":\"Regional Rural Banks\"},{\"id\":3,\"value\":\"Commercial Banks\"},{\"id\":4,\"value\":\"Microfinance institutions\"}]',3,2),(54,9,'Which of the below-mentioned institute are linked with the financial sector of India controlled by the Reserve Bank of India (RBI)?','[{\"id\":1,\"value\":\"Commercial Bank\"},{\"id\":2,\"value\":\"Money Lenders\"},{\"id\":3,\"value\":\"Stock Exchange Operations\"},{\"id\":4,\"value\":\"All the above\"}]',3,3),(55,9,' What does Price flooring mean?','[{\"id\":1,\"value\":\") Shortage\"},{\"id\":2,\"value\":\" Surpluses\"},{\"id\":3,\"value\":\"Equilibrium\"},{\"id\":4,\"value\":\"None of the above\"}]',2,3),(56,9,'What is the Gross National Product?','[{\"id\":1,\"value\":\" The total value of Good and services manufactured in the country\"},{\"id\":2,\"value\":\" The total value of all the transactions in the country\"},{\"id\":3,\"value\":\" Reduction in the total value of goods and services produced in the country\"},{\"id\":4,\"value\":\" The total worth of goods and services generated in the country and net factor income from abroad.\"}]',4,3),(57,9,'Why statistically the unemployment rate is low in India?','[{\"id\":1,\"value\":\"Only 3\"},{\"id\":2,\"value\":\"2 and 3\"},{\"id\":3,\"value\":\"Only 2\"},{\"id\":4,\"value\":\"All of the above\"}]',3,3),(58,9,'The bowed shape of the production possibilities curve illustrates.','[{\"id\":1,\"value\":\"Law of Increasing Marginal Cost\"},{\"id\":2,\"value\":\"The production is inefficient\"},{\"id\":3,\"value\":\"The production is unattainable\"},{\"id\":4,\"value\":\"The demand is relatively elastic\"}]',1,3),(59,9,'The main economic problem faced by all society is.','[{\"id\":1,\"value\":\"Unemployment\"},{\"id\":2,\"value\":\"Inequality\"},{\"id\":3,\"value\":\" Poverty\"},{\"id\":4,\"value\":\"Scarcity\"}]',4,5),(60,9,'“Capitalism” refers to?','[{\"id\":1,\"value\":\" The use of market\"},{\"id\":2,\"value\":\"Government ownership of capital\"},{\"id\":3,\"value\":\" Private ownership of capital goods\"},{\"id\":4,\"value\":\" Private ownership of homes & cars\"}]',3,5),(61,9,'. The goal of a pure market economy is to meet the desire of?','[{\"id\":1,\"value\":\"Consumers\"},{\"id\":2,\"value\":\"Companies\"},{\"id\":3,\"value\":\" Workers\"},{\"id\":4,\"value\":\"The government\"}]',1,5),(62,9,' The law of demand means?','[{\"id\":1,\"value\":\"As the quantity demanded rises, the price rises\"},{\"id\":2,\"value\":\"As the price rises, the quantity demanded rises\"},{\"id\":3,\"value\":\" As the price rises, the quantity demanded falls\"},{\"id\":4,\"value\":\"As supply rises, the demand rises\"}]',3,5),(63,9,'The example of agriculture price support program is?','[{\"id\":1,\"value\":\"A price ceiling\"},{\"id\":2,\"value\":\"A price floor\"},{\"id\":3,\"value\":\"Equilibrium pricing\"},{\"id\":4,\"value\":\" None of the above\"}]',2,5),(64,10,'What fraction of Rajasthan’s total area is covered by Thar Desert?','[{\"id\":1,\"value\":\"Around 30%\"},{\"id\":2,\"value\":\"Around 40%\"},{\"id\":3,\"value\":\" Around 60%\"},{\"id\":4,\"value\":\"Around 70%\"}]',3,1),(65,10,'The Dampier-Hodges line is related to which of the following?','[{\"id\":1,\"value\":\"Bay of Cambay\"},{\"id\":2,\"value\":\"Palk Strait\"},{\"id\":3,\"value\":\"Andaman and Nicobar Islands\"},{\"id\":4,\"value\":\"Sundarbans\"}]',4,1),(66,10,'Which of the following is India’s largest salt producing state?','[{\"id\":1,\"value\":\"Rajasthan\"},{\"id\":2,\"value\":\"Gujarat\"},{\"id\":3,\"value\":\"Odisha\"},{\"id\":4,\"value\":\"Tamil Nadu\"}]',2,1),(67,10,'The Bharat Oman Refineries Ltd operates which of the following refineries?','[{\"id\":1,\"value\":\"Bongaigaon Refinery\"},{\"id\":2,\"value\":\"Bina Refinery\"},{\"id\":3,\"value\":\"Haldia Refinery\"},{\"id\":4,\"value\":\"Numaligarh Refinery\"}]',2,1),(68,10,'The Kachin Hills make a boundary between India and which of the following neighbors?','[{\"id\":1,\"value\":\"Bhutan\"},{\"id\":2,\"value\":\"Myanmar\"},{\"id\":3,\"value\":\"Nepal\"},{\"id\":4,\"value\":\"China\"}]',2,1),(69,10,'Which of the following is a correct sequence of sea ports of India from “South to North”?','[{\"id\":1,\"value\":\"Cochin ?Thiruvananthapuram?Calicut?Mangalore\"},{\"id\":2,\"value\":\"Calicut? Thiruvananthapuram? Cochin? Mangalore\"},{\"id\":3,\"value\":\"Thiruvananthapuram? Cochin? Calicut? Mangalore\"},{\"id\":4,\"value\":\"Thiruvananthapuram? Calicut? Mangalore? Cochin\"}]',3,2),(70,10,'The northernmost point of India is known as:','[{\"id\":1,\"value\":\"Indira Heights\"},{\"id\":2,\"value\":\"Indira Col\"},{\"id\":3,\"value\":\"Indira Point\"},{\"id\":4,\"value\":\"] None of the above\"}]',2,2),(71,10,'Which of the following states is sole producer of agate, chalk, and perlite in India?','[{\"id\":1,\"value\":\"Rajasthan\"},{\"id\":2,\"value\":\"Karnataka\"},{\"id\":3,\"value\":\"Gujarat\"},{\"id\":4,\"value\":\"Tamil Nadu\"}]',3,2),(72,10,'Which of the following state does not share boundary with Myanmar?','[{\"id\":1,\"value\":\"Assam\"},{\"id\":2,\"value\":\"Arunachal Pradesh\"},{\"id\":3,\"value\":\"Nagaland\"},{\"id\":4,\"value\":\"Manipur\"}]',1,2),(73,10,'If a match live commentary in Delhi commences at 10.00 am, at what time the viewer at London should tune into?','[{\"id\":1,\"value\":\"4.00 a.m.\"},{\"id\":2,\"value\":\"4.30 a.m.\"},{\"id\":3,\"value\":\"4.45 a.m.\"},{\"id\":4,\"value\":\"4.50 a.m\"}]',2,2),(74,10,'The Puna grassland ecoregion is found in which of the following continents?','[{\"id\":1,\"value\":\"Asia\"},{\"id\":2,\"value\":\"Africa\"},{\"id\":3,\"value\":\"North America\"},{\"id\":4,\"value\":\"South America\"}]',4,3),(75,10,'Mars Atmosphere and Volatile Evolution Mission (MAVEN) is a space probe developed to study the atmosphere of Mars. It has been developed by _?','[{\"id\":1,\"value\":\"Indian Space Research Organisation (ISRO)\"},{\"id\":2,\"value\":\"China National Space Administration (CNSA)\"},{\"id\":3,\"value\":\"National Aeronautics and Space Administration (NASA)\"},{\"id\":4,\"value\":\"Russian Federal Space Agency (RFSA)\"}]',3,3),(76,10,'Which of the following countries does not share its border with Black Sea?','[{\"id\":1,\"value\":\"Georgia\"},{\"id\":2,\"value\":\"Bulgaria\"},{\"id\":3,\"value\":\"Belarus\"},{\"id\":4,\"value\":\"Turkey\"}]',3,3),(77,10,'Which of the following straits connect Mediterranean Sea to the Atlantic Ocean?','[{\"id\":1,\"value\":\"Strait of Hormuz\"},{\"id\":2,\"value\":\"Strait of Gibraltar\"},{\"id\":3,\"value\":\"Bosporus Strait\"},{\"id\":4,\"value\":\"Dover Strait\"}]',2,3),(78,10,'Which of the following is not an equatorial crop?','[{\"id\":1,\"value\":\"Coconut\"},{\"id\":2,\"value\":\"Rubber\"},{\"id\":3,\"value\":\"Oil Palm\"},{\"id\":4,\"value\":\"Banana\"}]',4,3),(79,10,'Which of the following countries is not a part of Melanesia region in the pacific ocean?','[{\"id\":1,\"value\":\"Vanuatu\"},{\"id\":2,\"value\":\"Solomon Islands\"},{\"id\":3,\"value\":\"Fiji\"},{\"id\":4,\"value\":\"Kiribati\"}]',4,5),(80,10,'Pedogenesis is the process in which:','[{\"id\":1,\"value\":\"Mountains are formed\"},{\"id\":2,\"value\":\"Soils are formed\"},{\"id\":3,\"value\":\"Gases are formed\"},{\"id\":4,\"value\":\"Oceans are formed\"}]',2,5),(81,10,'Which of the following is studied under Physical geography?','[{\"id\":1,\"value\":\"Economic activities\"},{\"id\":2,\"value\":\"Human Migration\"},{\"id\":3,\"value\":\"Soils\"},{\"id\":4,\"value\":\"Settlements\"}]',3,5),(82,10,'Which of the following is the least dense planet among all the planets?','[{\"id\":1,\"value\":\"Earth\"},{\"id\":2,\"value\":\"Uranus\"},{\"id\":3,\"value\":\"Jupiter\"},{\"id\":4,\"value\":\"Saturn\"}]',4,5),(83,10,'Which of the following planet is known as Morning star?','[{\"id\":1,\"value\":\"Earth\"},{\"id\":2,\"value\":\"Venus\"},{\"id\":3,\"value\":\"Mercury\"},{\"id\":4,\"value\":\"Jupiter\"}]',2,5),(84,11,' framework made cracking of vulnerabilities easy like point and click','[{\"id\":1,\"value\":\".Net\"},{\"id\":2,\"value\":\"Metasploit\"},{\"id\":3,\"value\":\"Zeus\"},{\"id\":4,\"value\":\"Ettercap\"}]',2,1),(85,11,'is a popular tool used for discovering networks as well as in security auditing.','[{\"id\":1,\"value\":\"Ettercap\"},{\"id\":2,\"value\":\"Metasploit\"},{\"id\":3,\"value\":\"Nmap\"},{\"id\":4,\"value\":\"Burp Suit\"}]',3,1),(86,11,' Which of this Nmap do not check?','[{\"id\":1,\"value\":\"services different hosts are offering\"},{\"id\":2,\"value\":\") on what OS they are running\"},{\"id\":3,\"value\":\"what kind of firewall is in use\"},{\"id\":4,\"value\":\"what type of antivirus is in use\"}]',4,1),(87,11,' Which of the following deals with network intrusion detection and real-time traffic analysis?','[{\"id\":1,\"value\":\" John the Ripper\"},{\"id\":2,\"value\":\"L0phtCrack\"},{\"id\":3,\"value\":\"Snort\"},{\"id\":4,\"value\":\"Nessus\"}]',3,1),(88,11,'Wireshark is a ____________ tool.','[{\"id\":1,\"value\":\"network protocol analysis\"},{\"id\":2,\"value\":\" network connection security\"},{\"id\":3,\"value\":\"connection analysis\"},{\"id\":4,\"value\":\"defending malicious packet-filtering\"}]',1,1),(89,11,'Which of the below-mentioned tool is used for Wi-Fi hacking?','[{\"id\":1,\"value\":\"Wireshark\"},{\"id\":2,\"value\":\"Nessus\"},{\"id\":3,\"value\":\" Aircrack-ng\"},{\"id\":4,\"value\":\"Snort\"}]',3,2),(90,11,' Aircrack-ng is used for ','[{\"id\":1,\"value\":\" Firewall bypassing\"},{\"id\":2,\"value\":\"Wi-Fi attacks\"},{\"id\":3,\"value\":\"Packet filtering\"},{\"id\":4,\"value\":\" System password cracking\"}]',2,2),(91,11,'is a popular IP address and port scanner.','[{\"id\":1,\"value\":\"Cain and Abel\"},{\"id\":2,\"value\":\"Snort\"},{\"id\":3,\"value\":\"Angry IP Scanner\"},{\"id\":4,\"value\":\"Ettercap\"}]',3,2),(92,11,' is a popular tool used for network analysis in multiprotocol diverse network.','[{\"id\":1,\"value\":\"Snort\"},{\"id\":2,\"value\":\"SuperScan\"},{\"id\":3,\"value\":\"Burp Suit\"},{\"id\":4,\"value\":\"EtterPeak\"}]',4,2),(93,11,' scans TCP ports and resolves different hostnames.','[{\"id\":1,\"value\":\"SuperScan\"},{\"id\":2,\"value\":\" Snort\"},{\"id\":3,\"value\":\"Ettercap\"},{\"id\":4,\"value\":\"QualysGuard\"}]',1,2),(94,11,' is a web application assessment security tool.','[{\"id\":1,\"value\":\"LC4\"},{\"id\":2,\"value\":\"WebInspect\"},{\"id\":3,\"value\":\" Ettercap\"},{\"id\":4,\"value\":\"QualysGuard\"}]',2,3),(95,11,'Which of the following attack-based checks WebInspect cannot do?','[{\"id\":1,\"value\":\" cross-site scripting\"},{\"id\":2,\"value\":\"directory traversal\"},{\"id\":3,\"value\":\" parameter injection\"},{\"id\":4,\"value\":\"injecting shell code\"}]',4,3),(96,11,' is a password recovery and auditing tool.','[{\"id\":1,\"value\":\"LC3\"},{\"id\":2,\"value\":\" LC4\"},{\"id\":3,\"value\":\"Network Stumbler\"},{\"id\":4,\"value\":\"Maltego\"}]',2,3),(97,11,'Which of the following attach is not used by LC4 to recover Windows password?','[{\"id\":1,\"value\":\"Brute-force attack\"},{\"id\":2,\"value\":\"Dictionary attack\"},{\"id\":3,\"value\":\" MiTM attack\"},{\"id\":4,\"value\":\"Hybrid attacks\"}]',3,3),(98,11,' is the world’s most popular vulnerability scanner used in companies for checking vulnerabilities in the network.','[{\"id\":1,\"value\":\"Wireshark\"},{\"id\":2,\"value\":\" Nessus\"},{\"id\":3,\"value\":\" Snort\"},{\"id\":4,\"value\":\"WebInspect\"}]',2,3),(99,11,'is a tool which can detect registry issues in an operating system.','[{\"id\":1,\"value\":\"Network Stumbler\"},{\"id\":2,\"value\":\"Ettercap\"},{\"id\":3,\"value\":\" Maltego\"},{\"id\":4,\"value\":\" LANguard Network Security Scanner\"}]',4,5),(100,11,'ToneLoc is abbreviated as ','[{\"id\":1,\"value\":\" Tone Locking\"},{\"id\":2,\"value\":\" Tone Locator\"},{\"id\":3,\"value\":\"Tone Locker\"},{\"id\":4,\"value\":\"Tune Locator\"}]',3,5),(101,11,' is a debugger and exploration tool.','[{\"id\":1,\"value\":\"Netdog\"},{\"id\":2,\"value\":\"Netcat\"},{\"id\":3,\"value\":\"Tcpdump\"},{\"id\":4,\"value\":\" BackTrack\"}]',2,5),(102,11,' is a popular command-line packet analyser.','[{\"id\":1,\"value\":\"Wireshark\"},{\"id\":2,\"value\":\"Snort\"},{\"id\":3,\"value\":\" Metasploit\"},{\"id\":4,\"value\":\" Tcpdump\"}]',4,5),(103,11,'is a platform that essentially keeps the log of data from networks, devices as well as applications in a single location.','[{\"id\":1,\"value\":\"EventLog Analyser\"},{\"id\":2,\"value\":\" NordVPN\"},{\"id\":3,\"value\":\"Wireshark\"},{\"id\":4,\"value\":\" PacketFilter Analyzer\"}]',1,5);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role_state` int(11) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_at` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_by` bigint(20) NOT NULL,
  `updated_at` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN',1,1,'2019-10-28 11:11:11.222',1,'2019-10-28 11:11:11.222'),(2,'Examination Head',1,1,'2020-02-04 21:53:06.921',1,'2020-02-04 21:53:06.876'),(3,'Student',1,1,'2020-02-04 21:53:15.462',1,'2020-02-04 21:53:15.462');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_screen_mapping`
--

DROP TABLE IF EXISTS `role_screen_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_screen_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_id` bigint(20) NOT NULL,
  `s_id` bigint(20) NOT NULL,
  `rowstate` int(11) NOT NULL,
  `RWUD` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FOREIGN R_R` (`r_id`),
  KEY `FOREIGN R_S` (`s_id`),
  CONSTRAINT `FOREIGN R_R` FOREIGN KEY (`r_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FOREIGN R_S` FOREIGN KEY (`s_id`) REFERENCES `screens` (`screen_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_screen_mapping`
--

LOCK TABLES `role_screen_mapping` WRITE;
/*!40000 ALTER TABLE `role_screen_mapping` DISABLE KEYS */;
INSERT INTO `role_screen_mapping` VALUES (160,2,13,1,'1~1~1~1'),(161,2,14,1,'1~1~1~1'),(162,2,15,1,'1~1~1~1'),(163,2,18,1,'1~1~1~1'),(164,2,19,1,'1~1~1~1'),(165,2,20,1,'1~1~1~1'),(166,2,21,1,'1~1~1~1'),(167,1,8,1,'1~1~1~1'),(168,1,9,1,'1~1~1~1'),(169,1,10,1,'1~1~1~1'),(170,1,11,1,'1~1~1~1'),(171,1,12,1,'1~1~1~1'),(172,1,13,1,'1~1~1~1'),(173,1,14,1,'1~1~1~1'),(174,1,15,1,'1~1~1~1'),(175,1,16,1,'1~1~1~1'),(176,1,17,1,'1~1~1~1'),(177,1,18,1,'1~1~1~1'),(178,1,19,1,'1~1~1~1'),(179,1,20,1,'1~1~1~1'),(180,1,21,1,'1~1~1~1'),(181,1,22,1,'1~1~1~1'),(182,3,19,1,'1~1~1~1'),(183,3,21,1,'1~1~1~1'),(184,3,22,1,'1~1~1~1');
/*!40000 ALTER TABLE `role_screen_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screens`
--

DROP TABLE IF EXISTS `screens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screens` (
  `screen_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `screen_name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `screen_url` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `screen_parent` bigint(20) NOT NULL,
  `screen_menu_level` int(11) NOT NULL,
  `rowstate` int(11) NOT NULL,
  `screen_icon` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`screen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screens`
--

LOCK TABLES `screens` WRITE;
/*!40000 ALTER TABLE `screens` DISABLE KEYS */;
INSERT INTO `screens` VALUES (8,'Administrative Tools','#',0,0,1,'fa fa-users'),(9,'Screen Management','administrative_tools/ScreenManagement.jsp',8,0,1,''),(10,'Role Management','administrative_tools/RoleManagement.jsp',8,0,1,''),(11,'User Management','administrative_tools/UserManagement.jsp',8,0,1,''),(12,'Subject Management','#',0,0,1,'fa fa-pencil'),(13,'Questions Management','#',0,0,1,'fa fa-question'),(14,'Create Questions','examination/que/CreateQuestion.jsp',13,0,1,''),(15,'Update Question','examination/que/UpdateQuestion.jsp',13,0,1,''),(16,'Create Subject','examination/subject/CreateSubject.jsp',12,0,1,''),(17,'Update Subject','examination/subject/UpdateSubject.jsp',12,0,1,''),(18,'Upload Bulk Questions','examination/que/UploadBulkQuestions.jsp',13,0,1,''),(19,'Examination Management','#',0,0,1,'fa  fa-pencil-square-o'),(20,'Examination & QP','examination/exam_management/CreateExamination.jsp',19,0,1,''),(21,'View Examinations','examination/exam_management/ViewExaminations.jsp',19,0,1,''),(22,'Applied Examination','examination/exam_management/AppliedExamination.jsp',19,0,1,'');
/*!40000 ALTER TABLE `screens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) DEFAULT NULL,
  `subjectcode` varchar(45) DEFAULT NULL,
  `subject_head` bigint(20) DEFAULT NULL,
  `subject_admission_start_date` date DEFAULT NULL,
  `subject_admission_end_date` date DEFAULT NULL,
  `subject_examination_date` date DEFAULT NULL,
  `subject_result_date` date DEFAULT NULL,
  `subject_fee` bigint(20) DEFAULT NULL,
  `subject_description` mediumtext,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (7,'JAVA','2020-02-07T16:59:40.419Z',1,'2020-02-13','2020-02-12','2020-02-14','2020-02-15',200,'jasbcbacbc'),(8,'JAVA Programming update','2020-02-07T16:59:40.419Z',5,'2020-02-13','2020-02-12','2020-02-14','2020-02-15',200,'jasbcbacbc'),(9,'ECONOMICS','2020-02-19T15:37:56.224Z',5,'2020-02-02','2020-02-01','2020-02-03','2020-02-05',400,'ECONOMIC BOARD EXAM'),(10,'Geography','2020-02-21T08:00:43.662Z',5,'2020-02-19','2020-02-08','2020-02-24','2020-02-28',900,'Geography Desc'),(11,'Network Security','2020-02-21T08:08:18.057Z',2,'2020-02-08','2020-02-01','2020-02-11','2020-02-15',1200,'NS desc');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mobile` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `c_by` bigint(20) NOT NULL,
  `c_at` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `u_by` bigint(20) NOT NULL,
  `u_at` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pas` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ashish Gaikwad','07/09/1998','Ashish@1997','ashishgaikwad1997@gmail.com','8976834278',1,0,'',1,'1582825317032',NULL),(2,'Ananya Kakade','21/10/1998','Kakade@123','ananyakakade10@gmail.com','8983190809',1,1,'1580832395878',1,'1580832395878',NULL),(9,'Student Ashish','07/09/1997','Student@1','ashishgaikwad.6677@gmail.com','8976834278',1,1,'1582907021718',1,'1582907021718','BATU_1582907001284.jpg,BATU_1582907009033.jpg'),(10,'tmpUser','30/03/2000','a.1234567','rutikgaikwad.2k@gmail.com','7208339425',1,1,'1582907186335',1,'1582907186335',NULL),(11,'Rutik Gaikwad','30/03/2000','a.123123123','ashishgaikwad6268@gmail.com','7977407828',1,1,'1582908064078',1,'1582909250942','BATU_1582908047006.jpg,BATU_1582908053088.jpg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_role_mapping`
--

DROP TABLE IF EXISTS `users_role_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_role_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  `rowstate` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_role_mapping`
--

LOCK TABLES `users_role_mapping` WRITE;
/*!40000 ALTER TABLE `users_role_mapping` DISABLE KEYS */;
INSERT INTO `users_role_mapping` VALUES (1,1,1,1),(2,2,1,1),(3,3,1,1),(4,4,2,1),(5,5,2,1),(6,6,3,1),(7,0,3,1),(8,0,3,1),(9,0,3,1),(10,0,3,1),(11,7,3,1),(12,8,3,1),(13,9,3,1),(14,10,3,1),(15,11,3,1);
/*!40000 ALTER TABLE `users_role_mapping` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-11  9:36:58
