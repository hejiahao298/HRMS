/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3307
 Source Schema         : HRMS

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 06/11/2024 17:15:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Departments
-- ----------------------------
DROP TABLE IF EXISTS `Departments`;
CREATE TABLE `Departments`  (
  `department_id` int(0) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `leader_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Departments
-- ----------------------------
INSERT INTO `Departments` VALUES (1, '财务部', 1);
INSERT INTO `Departments` VALUES (2, '人力资源部', 2);
INSERT INTO `Departments` VALUES (3, '技术部', 3);
INSERT INTO `Departments` VALUES (4, '市场部', 7);
INSERT INTO `Departments` VALUES (5, '销售部', 9);
INSERT INTO `Departments` VALUES (6, '客户服务部', 11);
INSERT INTO `Departments` VALUES (7, '研发部', 14);
INSERT INTO `Departments` VALUES (8, '行政部', 15);

-- ----------------------------
-- Table structure for Employees
-- ----------------------------
DROP TABLE IF EXISTS `Employees`;
CREATE TABLE `Employees`  (
  `employee_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hire_date` date NULL DEFAULT NULL,
  `expiry_date` date NULL DEFAULT NULL,
  `department_id` int(0) NULL DEFAULT NULL,
  `position_id` int(0) NULL DEFAULT NULL,
  `salary` float NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  INDEX `position_id`(`position_id`) USING BTREE,
  CONSTRAINT `Employees_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `Departments` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Employees_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `Positions` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Employees
-- ----------------------------
INSERT INTO `Employees` VALUES (1, '张三', 'zhangsan@example.com', '12345678901', '2023-01-10', '2026-01-10', 1, 1, 8000);
INSERT INTO `Employees` VALUES (2, '李四', 'lisi@example.com', '12345678902', '2023-03-15', '2026-03-15', 2, 2, 7000);
INSERT INTO `Employees` VALUES (3, '王五', 'wangwu@example.com', '12345678903', '2023-05-20', '2026-05-20', 3, 3, 12000);
INSERT INTO `Employees` VALUES (4, '赵六', 'zhaoliu@example.com', '12345678904', '2023-07-25', '2026-07-25', 4, 4, 9000);
INSERT INTO `Employees` VALUES (5, '孙七', 'sunqi@example.com', '12345678905', '2023-09-01', '2026-09-01', 5, 5, 10000);
INSERT INTO `Employees` VALUES (6, '周八', 'zhouba@example.com', '12345678906', '2023-10-12', '2026-10-12', 6, 6, 7500);
INSERT INTO `Employees` VALUES (7, '吴九', 'wujiu@example.com', '12345678907', '2023-11-22', '2026-11-22', 7, 7, 15000);
INSERT INTO `Employees` VALUES (8, '郑十', 'zhengshi@example.com', '12345678908', '2023-12-05', '2026-12-05', 8, 8, 6000);
INSERT INTO `Employees` VALUES (9, '钱十一', 'qianshiyi@example.com', '12345678909', '2024-01-20', '2027-01-20', 1, 9, 5000);
INSERT INTO `Employees` VALUES (10, '孙十二', 'sunshiier@example.com', '12345678910', '2024-02-28', '2027-02-28', 2, 10, 6500);
INSERT INTO `Employees` VALUES (11, '李十三', 'lishisan@example.com', '12345678911', '2024-03-18', '2027-03-18', 3, 11, 13000);
INSERT INTO `Employees` VALUES (12, '周十四', 'zhoushi@example.com', '12345678912', '2024-04-30', '2027-04-30', 4, 12, 8500);
INSERT INTO `Employees` VALUES (13, '吴十五', 'wushiwu@example.com', '12345678913', '2024-05-15', '2027-05-15', 5, 13, 11000);
INSERT INTO `Employees` VALUES (14, '郑十六', 'zhengshiliu@example.com', '12345678914', '2024-06-01', '2027-06-01', 6, 14, 8000);
INSERT INTO `Employees` VALUES (15, '王十七', 'wangshiqi@example.com', '12345678915', '2024-07-10', '2027-07-10', 7, 15, 15000);
INSERT INTO `Employees` VALUES (16, '冯十八', 'fengshi@example.com', '12345678916', '2024-08-05', '2027-08-05', 3, 3, 7000);
INSERT INTO `Employees` VALUES (20, '西', '276003@qq.com', '12345678916', '2024-11-05', '2024-11-30', 1, 2, 7000);
INSERT INTO `Employees` VALUES (21, '冯十八', '27600@qq.com', '12345678916', '2024-11-04', '2024-11-30', 1, 1, 7000);
INSERT INTO `Employees` VALUES (22, '小红', '27600@qq.com', '12345678916', '2024-11-04', '2024-11-07', 1, 2, 6000);

-- ----------------------------
-- Table structure for JobPositions
-- ----------------------------
DROP TABLE IF EXISTS `JobPositions`;
CREATE TABLE `JobPositions`  (
  `job_id` int(0) NOT NULL AUTO_INCREMENT,
  `position_id` int(0) NOT NULL,
  `department_id` int(0) NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `openings` int(0) NULL DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `post_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`job_id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  CONSTRAINT `JobPositions_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `Departments` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of JobPositions
-- ----------------------------
INSERT INTO `JobPositions` VALUES (1, 2, 1, '负责公司财务报表分析和预算管理', 2, '开放', '2024-01-01');
INSERT INTO `JobPositions` VALUES (2, 3, 2, '负责招聘、培训和员工关系管理', 1, '开放', '2024-01-05');
INSERT INTO `JobPositions` VALUES (3, 13, 3, '负责公司产品后端开发和架构设计', 3, '开放', '2024-01-10');

-- ----------------------------
-- Table structure for Positions
-- ----------------------------
DROP TABLE IF EXISTS `Positions`;
CREATE TABLE `Positions`  (
  `position_id` int(0) NOT NULL AUTO_INCREMENT,
  `position_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `department_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`position_id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  CONSTRAINT `Positions_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `Departments` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Positions
-- ----------------------------
INSERT INTO `Positions` VALUES (1, '会计', 1);
INSERT INTO `Positions` VALUES (2, '财务分析师', 1);
INSERT INTO `Positions` VALUES (3, '招聘专员', 2);
INSERT INTO `Positions` VALUES (4, '培训专员', 2);
INSERT INTO `Positions` VALUES (5, '软件工程师', 3);
INSERT INTO `Positions` VALUES (6, '前端开发', 3);
INSERT INTO `Positions` VALUES (7, '市场经理', 4);
INSERT INTO `Positions` VALUES (8, '市场专员', 4);
INSERT INTO `Positions` VALUES (9, '销售经理', 5);
INSERT INTO `Positions` VALUES (10, '销售代表', 5);
INSERT INTO `Positions` VALUES (11, '客户服务经理', 6);
INSERT INTO `Positions` VALUES (12, '客服专员', 6);
INSERT INTO `Positions` VALUES (13, '研发工程师', 7);
INSERT INTO `Positions` VALUES (14, '产品经理', 7);
INSERT INTO `Positions` VALUES (15, '行政经理', 8);
INSERT INTO `Positions` VALUES (16, '行政助理', 8);
INSERT INTO `Positions` VALUES (17, '人事经理', 2);

-- ----------------------------
-- Table structure for Users
-- ----------------------------
DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for DepartmentVO
-- ----------------------------
DROP VIEW IF EXISTS `DepartmentVO`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `DepartmentVO` AS select `D`.`department_id` AS `department_id`,`D`.`department_name` AS `department_name`,`E`.`name` AS `name`,`E`.`phone` AS `phone` from (`Departments` `D` left join `Employees` `E` on((`D`.`leader_id` = `E`.`employee_id`)));

-- ----------------------------
-- View structure for EmployeeVO
-- ----------------------------
DROP VIEW IF EXISTS `EmployeeVO`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `EmployeeVO` AS select `E`.`employee_id` AS `employee_id`,`E`.`name` AS `name`,`E`.`email` AS `email`,`E`.`phone` AS `phone`,`E`.`hire_date` AS `hire_date`,`D`.`department_name` AS `department_name`,`P`.`position_title` AS `position_title`,`E`.`expiry_date` AS `expiry_date`,`E`.`salary` AS `salary` from ((`Employees` `E` left join `Departments` `D` on((`E`.`department_id` = `D`.`department_id`))) left join `Positions` `P` on((`E`.`position_id` = `P`.`position_id`))) order by `E`.`employee_id`;

-- ----------------------------
-- View structure for JobPositionVO
-- ----------------------------
DROP VIEW IF EXISTS `JobPositionVO`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `JobPositionVO` AS select `J`.`job_id` AS `job_id`,`P`.`position_title` AS `position_title`,`D`.`department_name` AS `Department_name`,`J`.`description` AS `description`,`J`.`openings` AS `openings`,`J`.`status` AS `status`,`J`.`post_date` AS `post_date` from ((`JobPositions` `J` left join `Positions` `P` on((`J`.`position_id` = `P`.`position_id`))) left join `Departments` `D` on((`J`.`department_id` = `D`.`department_id`)));

-- ----------------------------
-- View structure for PositionVO
-- ----------------------------
DROP VIEW IF EXISTS `PositionVO`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `PositionVO` AS select `P`.`position_id` AS `position_id`,`P`.`position_title` AS `position_title`,`D`.`department_name` AS `department_name`,`D`.`department_id` AS `department_id` from (`Positions` `P` left join `Departments` `D` on((`P`.`department_id` = `D`.`department_id`)));

SET FOREIGN_KEY_CHECKS = 1;
