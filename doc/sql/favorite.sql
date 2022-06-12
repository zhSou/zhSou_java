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

 Date: 18/05/2022 15:25:38
*/


-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS "public"."favorite";
CREATE TABLE "public"."favorite" (
  "fid" int8 NOT NULL DEFAULT nextval('favorite_fid_seq'::regclass),
  "uid" int8,
  "aid" int8,
  "name" text COLLATE "pg_catalog"."default",
  "date" timestamp(6),
  "deleted" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO "public"."favorite" VALUES (1, 1, 7, 'testFolder1', '2022-05-17 21:48:12.848', 't');
INSERT INTO "public"."favorite" VALUES (2, 1, 6, '默认收藏夹', '2022-05-17 21:48:42.716', 'f');

-- ----------------------------
-- Primary Key structure for table favorite
-- ----------------------------
ALTER TABLE "public"."favorite" ADD CONSTRAINT "favorite_pkey" PRIMARY KEY ("fid");
