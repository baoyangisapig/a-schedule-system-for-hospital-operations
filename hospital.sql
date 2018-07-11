/*
 Navicat MySQL Data Transfer

 Source Server         : bb
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 11/07/2018 21:57:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `p_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `p_section` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  `d_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_section` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  `n_id` int(255) DEFAULT NULL,
  `n_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `n_id1` int(255) DEFAULT NULL,
  `n_name1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `roomnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES (1, 1, '张三', '脑外科', 1, '李时珍', '脑外科', '2018-07-09-09', '脑组织修复', 1, NULL, '', NULL, '', '101');
INSERT INTO `application` VALUES (2, 2, '李四', '骨科', 2, '周小平', '骨科', '2018-07-10-08', '股骨头切除', 2, NULL, '', NULL, '', '102');
INSERT INTO `application` VALUES (3, 3, '钱三', '泌尿外科', 3, '胡万', '泌尿外科', '2018-07-10-08', '前列腺切除', 1, NULL, NULL, NULL, NULL, '103');
INSERT INTO `application` VALUES (4, 4, '赵武', '耳鼻喉科', 4, '周晓会', '耳鼻喉科', '2018-07-09-09', '鼻癌细胞切除', 3, 6, '章小蕙', NULL, NULL, '104');
INSERT INTO `application` VALUES (5, 5, '孙文', '脑外科', 1, '李时珍', '脑外科', '2018-07-09-12', '脑震荡肿块切除', 2, NULL, NULL, NULL, NULL, '105');
INSERT INTO `application` VALUES (10, 1, '张三', '脑外科', 5, '陈岚', '骨科', '2018-07-18-09', '大脑切除', 3, 3, '王麻小', NULL, NULL, '208');
INSERT INTO `application` VALUES (11, 5, '包杨', '泌尿外科', 4, '周晓会', '耳鼻喉科', '2017-09-06-08', '股骨头切除', 3, 5, '周龙', NULL, NULL, '207');
INSERT INTO `application` VALUES (12, 8, '包小小', '骨科', 3, '胡万', '泌尿外科', '2018-07-13-06', '脑骨修复', 3, 2, '王麻丫', NULL, NULL, '302');

-- ----------------------------
-- Table structure for count
-- ----------------------------
DROP TABLE IF EXISTS `count`;
CREATE TABLE `count`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of count
-- ----------------------------
INSERT INTO `count` VALUES (1, 1, '1', 'doc00001', 'doc00001');
INSERT INTO `count` VALUES (2, 1, '2', 'pat00001', 'pat00001');
INSERT INTO `count` VALUES (3, 5, '1', 'doc00005', 'doc00005');
INSERT INTO `count` VALUES (4, 5, '2', 'pat00005', 'pat00005');
INSERT INTO `count` VALUES (5, 4, '1', 'doc00004', 'doc00004');
INSERT INTO `count` VALUES (6, 2, '1', 'doc00002', 'doc00002');
INSERT INTO `count` VALUES (7, 3, '1', 'doc00003', 'doc00003');
INSERT INTO `count` VALUES (8, 6, '1', 'doc00006', 'doc00006');
INSERT INTO `count` VALUES (9, 7, '1', 'doc00007', 'doc00007');
INSERT INTO `count` VALUES (10, 8, '1', 'doc00008', 'doc00008');
INSERT INTO `count` VALUES (11, 2, '2', 'pat00002', 'pat00002');
INSERT INTO `count` VALUES (12, 3, '2', 'pat00003', 'pat00003');
INSERT INTO `count` VALUES (13, 4, '2', 'pat00004', 'pat00004');
INSERT INTO `count` VALUES (14, 6, '2', 'pat00006', 'pat00006');
INSERT INTO `count` VALUES (15, 8, '2', 'by10086', 'by10086');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `section` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, '李时珍', '11000', '脑外科');
INSERT INTO `doctor` VALUES (2, '周小平', '11001', '骨科');
INSERT INTO `doctor` VALUES (3, '胡万', '11002', '泌尿外科');
INSERT INTO `doctor` VALUES (4, '周晓会', '11003', '耳鼻喉科');
INSERT INTO `doctor` VALUES (5, '陈岚', '11004', '骨科');
INSERT INTO `doctor` VALUES (6, '赵无极', '11005', '脑外科');
INSERT INTO `doctor` VALUES (7, '陈坤', '11006', '泌尿外科');
INSERT INTO `doctor` VALUES (8, '张三丰', '11007', '神经内科');

-- ----------------------------
-- Table structure for nurse
-- ----------------------------
DROP TABLE IF EXISTS `nurse`;
CREATE TABLE `nurse`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `img` varchar(2550) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nurse
-- ----------------------------
INSERT INTO `nurse` VALUES (1, '张麻子', '10010', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531197121913&di=249405582e0e642cd33db1c2be4995b9&imgtype=0&src=http%3A%2F%2Fwww.ygjj.com%2Fbookpic2%2F2016-05-30%2Fnew540712-20160530213900683573.JPG', '麻醉师', '1');
INSERT INTO `nurse` VALUES (2, '王麻丫', '10011', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531203098510&di=52b9eb216937acbe55cc76f0fe69c42e&imgtype=0&src=http%3A%2F%2Fwww.dfmhp.com.cn%2Fuploads%2Fallimg%2Fc101222%2F1292c21a46460-26019.jpg', '中级麻醉师', '2');
INSERT INTO `nurse` VALUES (3, '王麻小', '10012', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531807309&di=b65c17d5ca37c102fd9d8b81e2682e71&imgtype=jpg&er=1&src=http%3A%2F%2Fa2.att.hudong.com%2F64%2F13%2F01300543952390147218136437282.jpg', '高级麻醉师', '2');
INSERT INTO `nurse` VALUES (4, '李国旭', '10013', 'http://img3.imgtn.bdimg.com/it/u=3134756812,1575399381&fm=27&gp=0.jpg', '高级麻醉师', '1');
INSERT INTO `nurse` VALUES (5, '周龙', '10014', 'http://s8.sinaimg.cn/bmiddle/60390cdcx6bc2c0f9c1a7&690', '中级麻醉师', '2');
INSERT INTO `nurse` VALUES (6, '章小蕙', '10015', 'http://img.mp.itc.cn/upload/20160507/8322d6c6fe5d480fb376d5b1470281e4.jpg', '特级麻醉师', '2');
INSERT INTO `nurse` VALUES (7, '李鹏', '10016', 'http://www.hanshou.gov.cn/UploadFiles/hsgqt/2017/5/201705150920502766.JPG', '高级麻醉师', '1');
INSERT INTO `nurse` VALUES (8, '何云伟', '10017', 'http://s9.rr.itc.cn/r/wapChange/20168_10_3/a1sa0b1444101328855.jpg', '中级麻醉师', '1');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `section` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES (1, '张三', '8000', '脑外科');
INSERT INTO `patient` VALUES (2, '李四', '8001', '骨科');
INSERT INTO `patient` VALUES (3, '钱三', '8002', '泌尿外科');
INSERT INTO `patient` VALUES (4, '赵武', '8003', '耳鼻喉科');
INSERT INTO `patient` VALUES (5, '包杨', '44586', '泌尿外科');
INSERT INTO `patient` VALUES (6, '包小杨', '98129', '耳鼻喉科');
INSERT INTO `patient` VALUES (8, '包小小', '71285', '骨科');
INSERT INTO `patient` VALUES (9, '包小小', '36849', '骨科');

SET FOREIGN_KEY_CHECKS = 1;
