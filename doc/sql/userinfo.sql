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

 Date: 18/05/2022 15:26:08
*/


-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS "public"."userinfo";
CREATE TABLE "public"."userinfo" (
  "uid" int8 NOT NULL DEFAULT nextval('userinfo_uid_seq'::regclass),
  "username" text COLLATE "pg_catalog"."default" NOT NULL,
  "password" text COLLATE "pg_catalog"."default",
  "email" text COLLATE "pg_catalog"."default",
  "deleted" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO "public"."userinfo" VALUES (1, 'dai', 'e10adc3949ba59abbe56e057f20f883e', 'daizhen1995@126.com', 'f');
INSERT INTO "public"."userinfo" VALUES (2, 'ccc', 'e10adc3949ba59abbe56e057f20f883e', '123456@qq
.com', 'f');

-- ----------------------------
-- Primary Key structure for table userinfo
-- ----------------------------
ALTER TABLE "public"."userinfo" ADD CONSTRAINT "userinfo_pkey" PRIMARY KEY ("uid");
