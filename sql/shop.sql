/*

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50550
 Source Host           : localhost:3306
 Source Schema         : shop

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_shiro
-- ----------------------------
DROP TABLE IF EXISTS `admin_shiro`;
CREATE TABLE `admin_shiro`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shiro_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名字',
  `shiro_cont` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_shiro
-- ----------------------------
INSERT INTO `admin_shiro` VALUES (1, '超级管理员', '增改删');
INSERT INTO `admin_shiro` VALUES (2, '普通管理员', '增改');

-- ----------------------------
-- Table structure for admin_users
-- ----------------------------
DROP TABLE IF EXISTS `admin_users`;
CREATE TABLE `admin_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员昵称',
  `admin_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员账户',
  `admin_pwd` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `admin_shiro` int(11) NULL DEFAULT NULL COMMENT '管理员权限',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `admin_shiro`(`admin_shiro`) USING BTREE,
  CONSTRAINT `admin_users_ibfk_1` FOREIGN KEY (`admin_shiro`) REFERENCES `admin_shiro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_users
-- ----------------------------
INSERT INTO `admin_users` VALUES (1, '张三', 'admin', 'a', 2);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_userid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '收货地址',
  `pay_type` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `goods_name` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `goods_price` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品单价',
  `order_date` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下单时间',
  `order_succ` int(11) NULL DEFAULT NULL COMMENT '是否成功付款',
  `order_counts` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '总价',
  `order_code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `order_state` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `users_id`(`order_userid`) USING BTREE,
  CONSTRAINT `users_id` FOREIGN KEY (`order_userid`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rece_address
-- ----------------------------
DROP TABLE IF EXISTS `rece_address`;
CREATE TABLE `rece_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人姓名',
  `address` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `zipcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `iphone` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货手机号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '该地址的所有者',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `address_id`(`user_id`) USING BTREE,
  CONSTRAINT `address_id` FOREIGN KEY (`user_id`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------


-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品单位',
  `goods_price` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品单价',
  `goods_num` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `users_id` int(11) NULL DEFAULT NULL COMMENT '购物车用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usersid`(`users_id`) USING BTREE,
  CONSTRAINT `usersid` FOREIGN KEY (`users_id`) REFERENCES `shop_user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名字',
  `goods_unit` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `goods_stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `goods_price` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单价',
  `goods_present` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品简介',
  `goods_type` int(11) NULL DEFAULT NULL COMMENT '种类',
  `goods_img` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type_id`(`goods_type`) USING BTREE,
  CONSTRAINT `type_id` FOREIGN KEY (`goods_type`) REFERENCES `shop_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES (1, '草莓', '500克', 100, '15.69', '草莓采摘园位于北京大兴区 庞各庄镇四各庄村 ，每年1月-6月面向北京以及周围城市提供新鲜草莓采摘和精品礼盒装草莓，草莓品种多样丰富，个大香甜。所有草莓均严格按照有机标准培育，不使用任何化肥和农药。草莓在采摘期间免洗可以直接食用。欢迎喜欢草莓的市民前来采摘，也欢迎各大单位选购精品有机草莓礼盒，有机草莓礼盒是亲朋馈赠、福利送礼的最佳选择', 1, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (2, '葡萄', '500克', 125, '12.00', '草莓采摘园位于北京大兴区 庞各庄镇四各庄村 ，每年1月-6月面向北京以及周围城市提供新鲜草莓采摘和精品礼盒装草莓，草莓品种多样丰富，个大香甜。所有草莓均严格按照有机标准培育，不使用任何化肥和农药。草莓在采摘期间免洗可以直接食用。欢迎喜欢草莓的市民前来采摘，也欢迎各大单位选购精品有机草莓礼盒，有机草莓礼盒是亲朋馈赠、福利送礼的最佳选择', 1, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (3, '柠檬', '500克', 95, '15.96', '草莓采摘园位于北京大兴区 庞各庄镇四各庄村 ，每年1月-6月面向北京以及周围城市提供新鲜草莓采摘和精品礼盒装草莓，草莓品种多样丰富，个大香甜。所有草莓均严格按照有机标准培育，不使用任何化肥和农药。草莓在采摘期间免洗可以直接食用。欢迎喜欢草莓的市民前来采摘，也欢迎各大单位选购精品有机草莓礼盒，有机草莓礼盒是亲朋馈赠、福利送礼的最佳选择', 1, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (4, '奇异果', '500克', 185, '18.45', '草莓采摘园位于北京大兴区 庞各庄镇四各庄村 ，每年1月-6月面向北京以及周围城市提供新鲜草莓采摘和精品礼盒装草莓，草莓品种多样丰富，个大香甜。所有草莓均严格按照有机标准培育，不使用任何化肥和农药。草莓在采摘期间免洗可以直接食用。欢迎喜欢草莓的市民前来采摘，也欢迎各大单位选购精品有机草莓礼盒，有机草莓礼盒是亲朋馈赠、福利送礼的最佳选择', 1, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (5, '青海龙虾', '350克', 123, '25.69', '很好吃，美味！！！！', 2, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (6, '扇贝', '350克', 110, '12.30', '很好吃，美味！！！！', 2, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (7, '秋刀鱼', '125克', 110, '15.50', '很好吃，美味！！！！', 2, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (8, '基围虾', '400克', 110, '30.50', '很好吃，美味！！！！', 2, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (9, '猪肉', '250克', 110, '12.50', '肉！！！！', 3, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (10, '鸡肉', '250克', 110, '18.00', '肉！！！！', 3, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (11, '羊肉', '250克', 110, '20.00', '肉！！！！', 3, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (12, '牛肉', '250克', 110, '25.63', '肉！！！！', 3, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (13, '鸡蛋', '500克', 123, '18.60', '蛋营养高！！！', 4, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (14, '鸭蛋', '500克', 123, '18.60', '蛋营养高！！！', 4, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (15, '鹅蛋', '500克', 123, '18.60', '蛋营养高！！！', 4, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (16, '鹌鹑蛋', '500克', 123, '18.60', '蛋营养高！！！', 4, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (17, '波菜', '500克', 152, '12.50', '多吃蔬菜', 5, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (18, '芹菜', '500克', 152, '12.50', '多吃蔬菜', 5, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (19, '白菜', '500克', 152, '12.50', '多吃蔬菜', 5, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (20, '空心菜', '500克', 152, '12.50', '多吃蔬菜', 5, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (21, '饺子', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (22, '丸子', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (23, '鱼丸', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (24, '冰块', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (27, '冰块2', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (28, '冰块3', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (29, '冰块4', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (30, '冰块5', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (31, '冰块6', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (32, '冰块7', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (33, '冰块8', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (34, '冰块9', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (35, '冰块10', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (36, '冰块12', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (37, '冰块13', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (38, '冰块14', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (39, '冰块15', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (40, '冰块16', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (41, '冰块17', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (42, '冰块18', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (43, '冰块19', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');
INSERT INTO `shop_goods` VALUES (44, '冰块20', '300克', 152, '15.50', '速冻食品吃起来方便', 6, 'goods.jpg');

-- ----------------------------
-- Table structure for shop_type
-- ----------------------------
DROP TABLE IF EXISTS `shop_type`;
CREATE TABLE `shop_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品种类',
  `date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_type
-- ----------------------------
INSERT INTO `shop_type` VALUES (1, '新鲜水果', '2019-08-07');
INSERT INTO `shop_type` VALUES (2, '海鲜水产', '2019-08-07');
INSERT INTO `shop_type` VALUES (3, '猪肉羊肉', '2019-08-07');
INSERT INTO `shop_type` VALUES (4, '禽类蛋品', '2019-08-07');
INSERT INTO `shop_type` VALUES (5, '新鲜素菜', '2019-08-07');
INSERT INTO `shop_type` VALUES (6, '速冻食品', '2019-08-07');

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `users` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `iphone` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `is_pay_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES (1, 'aaa', '123', '123@qq.com', '123456', '中国', '。。。。');

SET FOREIGN_KEY_CHECKS = 1;
