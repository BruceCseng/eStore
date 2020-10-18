/*
 Navicat Premium Data Transfer

 Source Server         : 联想服务器
 Source Server Type    : MySQL
 Source Server Version : 50529
 Source Host           : 192.168.31.32:3306
 Source Schema         : eStore_goods

 Target Server Type    : MySQL
 Target Server Version : 50529
 File Encoding         : 65001

 Date: 01/10/2020 00:43:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_album
-- ----------------------------
DROP TABLE IF EXISTS `tb_album`;
CREATE TABLE `tb_album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '相册标题',
  `image` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '相册封面图片',
  `image_item` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT 'json格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='相册表';

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌名称',
  `image` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
  `letter` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌首字母',
  `sort` int(10) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品品牌表';

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
BEGIN;
INSERT INTO `tb_brand` VALUES (1, '华为', NULL, 'H', 1);
INSERT INTO `tb_brand` VALUES (2, '小米', NULL, 'X', 2);
INSERT INTO `tb_brand` VALUES (3, '锤子', NULL, 'C', 3);
INSERT INTO `tb_brand` VALUES (4, '三星', NULL, 'S', 4);
INSERT INTO `tb_brand` VALUES (5, '联想', NULL, 'L', 5);
COMMIT;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `goods_num` int(10) DEFAULT NULL COMMENT '商品数量',
  `is_show` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '0-不显示，1-显示',
  `is_menu` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '0-不是导航，1-是导航',
  `sort` int(10) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL COMMENT '上级id，0-一级分类，其他为正常的parent',
  `template_id` int(10) DEFAULT NULL COMMENT '模板id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='品类表';

-- ----------------------------
-- Table structure for tb_category_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_category_brand`;
CREATE TABLE `tb_category_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category_id` int(10) NOT NULL COMMENT '品类id',
  `brand_id` int(10) NOT NULL COMMENT '品牌id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='品类品牌关系表';

-- ----------------------------
-- Table structure for tb_para
-- ----------------------------
DROP TABLE IF EXISTS `tb_para`;
CREATE TABLE `tb_para` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `options` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '选项',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `template_id` int(10) DEFAULT NULL COMMENT '模板id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='参数表';

-- ----------------------------
-- Table structure for tb_sku
-- ----------------------------
DROP TABLE IF EXISTS `tb_sku`;
CREATE TABLE `tb_sku` (
  `id` int(10) NOT NULL,
  `sn` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '商品条码',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'SKU名称',
  `price` int(10) DEFAULT NULL COMMENT '价格(分)',
  `num` int(10) DEFAULT NULL COMMENT '库存数量',
  `alert_num` int(10) DEFAULT NULL COMMENT '库存预警数量',
  `image` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片',
  `images` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片列表',
  `weight` int(10) DEFAULT NULL COMMENT '重量(克)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `spu_id` int(10) DEFAULT NULL COMMENT 'SPUID',
  `category_id` int(10) DEFAULT NULL COMMENT '品类id',
  `category_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '品类名称',
  `brand_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌名称',
  `spec` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '规格',
  `sale_num` int(10) DEFAULT NULL COMMENT '销量',
  `comment_num` int(10) DEFAULT NULL COMMENT '评论数',
  `status` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '商品状态1-正常，2-下架，3-下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SKU商品表';

-- ----------------------------
-- Table structure for tb_spec
-- ----------------------------
DROP TABLE IF EXISTS `tb_spec`;
CREATE TABLE `tb_spec` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `options` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '规格选项',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `template_id` int(10) DEFAULT NULL COMMENT '模板id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='规格表';

-- ----------------------------
-- Records of tb_spec
-- ----------------------------
BEGIN;
INSERT INTO `tb_spec` VALUES (1, '尺码', '165,170,175', NULL, NULL);
INSERT INTO `tb_spec` VALUES (2, '网络', '联通3G,联通4G,联通5G', NULL, NULL);
INSERT INTO `tb_spec` VALUES (3, '手机屏幕尺寸', '5寸,5.5寸', NULL, NULL);
INSERT INTO `tb_spec` VALUES (4, '机身内存', '32G,128G,256G', NULL, NULL);
INSERT INTO `tb_spec` VALUES (5, '颜色', '红色,黄色,绿色,蓝色,黑色,白色', NULL, NULL);
INSERT INTO `tb_spec` VALUES (6, '像素', '800万像素,1000万像素', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_spu
-- ----------------------------
DROP TABLE IF EXISTS `tb_spu`;
CREATE TABLE `tb_spu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sn` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '货号',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'spu名',
  `caption` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '副标题',
  `brand_id` int(10) DEFAULT NULL COMMENT '品牌id',
  `category1_id` int(10) DEFAULT NULL COMMENT '一级分类',
  `category2_id` int(10) DEFAULT NULL COMMENT '二级分类',
  `category3_id` int(10) DEFAULT NULL COMMENT '三级分类',
  `freight_id` int(10) DEFAULT NULL COMMENT '运费模板id',
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `images` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '图片列表',
  `sale_service` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '售后服务',
  `introduction` text COLLATE utf8_bin COMMENT '介绍',
  `spec_items` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '规格列表',
  `para_items` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '参数列表',
  `sale_num` int(10) DEFAULT NULL COMMENT '销量',
  `comment_num` int(10) DEFAULT NULL COMMENT '评论数',
  `is_marketable` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '是否上架',
  `is_enable_spec` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '是否启用规格',
  `is_delete` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '是否删除',
  `status` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='spu表';

-- ----------------------------
-- Table structure for tb_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_template`;
CREATE TABLE `tb_template` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '模板名称',
  `spec_num` int(10) DEFAULT NULL COMMENT '规格数量(统计用)',
  `para_num` int(10) DEFAULT NULL COMMENT '参数数量(统计用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='模板表';

-- ----------------------------
-- Records of tb_template
-- ----------------------------
BEGIN;
INSERT INTO `tb_template` VALUES (1, '手机', NULL, NULL);
INSERT INTO `tb_template` VALUES (2, '电视', NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
