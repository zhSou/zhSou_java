/*
 Navicat Premium Data Transfer

 Source Server         : 129
 Source Server Type    : PostgreSQL
 Source Server Version : 130006
 Source Host           : 192.168.198.129:5432
 Source Catalog        : zhsou
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130006
 File Encoding         : 65001

 Date: 18/05/2022 15:25:59
*/


-- ----------------------------
-- Table structure for folder
-- ----------------------------
DROP TABLE IF EXISTS "public"."folder";
CREATE TABLE "public"."folder" (
  "fid" int8 NOT NULL DEFAULT nextval('folder_fid_seq'::regclass),
  "uid" int8,
  "name" text COLLATE "pg_catalog"."default",
  "deleted" bool NOT NULL DEFAULT false,
  "date" timestamp(6)
)
;

-- ----------------------------
-- Records of folder
-- ----------------------------
INSERT INTO "public"."folder" VALUES (1, 1, '默认收藏夹', 'f', '2022-05-09 20:06:40.124');
INSERT INTO "public"."folder" VALUES (2, 1, 'test', 't', '2022-05-17 21:31:51.671');
INSERT INTO "public"."folder" VALUES (3, 1, 'testFolder1', 'f', '2022-05-17 21:32:10.851');

-- ----------------------------
-- Primary Key structure for table folder
-- ----------------------------
ALTER TABLE "public"."folder" ADD CONSTRAINT "folder_pkey" PRIMARY KEY ("fid");
