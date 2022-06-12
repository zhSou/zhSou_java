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

 Date: 18/05/2022 15:25:04
*/


-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS "public"."article";
CREATE TABLE "public"."article" (
  "aid" int8 NOT NULL DEFAULT nextval('article_aid_seq'::regclass),
  "url" text COLLATE "pg_catalog"."default",
  "raw" text COLLATE "pg_catalog"."default",
  "vector" tsvector,
  "deleted" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO "public"."article" VALUES (3, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20200326%2Fffc00cb6bc944e5b9ab2673c4873b24c.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1632531279&t=1b9ba84f70ddebdda6601a5576d37c50', '美沃可视数码裂隙灯,检查眼前节健康状况', '''健康'':8 ''数码'':3 ''检查'':6 ''沃'':2 ''灯'':5 ''状况'':9 ''美'':1 ''节'':7 ''裂隙'':4', 'f');
INSERT INTO "public"."article" VALUES (4, 'https://pic.rmb.bdstatic.com/19539b3b1a7e1daee93b0f3d99b8e795.png', '曾是名不见经传的王平,为何能够取代魏延,成为蜀汉', '''取代'':5 ''名不见经传'':2 ''成为'':7 ''是'':1 ''王平'':3 ''能够'':4 ''蜀汉'':8 ''魏延'':6', 'f');
INSERT INTO "public"."article" VALUES (5, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.gansudaily.com.cn%2F0%2F12%2F62%2F59%2F12625968_196506.jpg&refer=http%3A%2F%2Fpic.gansudaily.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1632538485&t=277064117f636b74a804f0768f6944e0', '探访六盘山隧道 犹如海底世界', '''世界'':6 ''六盘山'':2 ''探访'':1 ''海底'':5 ''犹如'':4 ''隧道'':3', 'f');
INSERT INTO "public"."article" VALUES (6, 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2021%252F0513%252F7fe81826j00qt0wen001lc000iq00bhm.jpg%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1632532438&t=c7b2f45a34d5a801328415a01fa934c4', '43岁的布冯还能扑点他熬老了一大批门将也定义了一个时代', '''了'':7,10 ''定义'':9 ''布冯'':1 ''扑'':3 ''时代'':11 ''点'':4 ''熬'':5 ''老'':6 ''能'':2 ''门将'':8', 'f');

-- ----------------------------
-- Indexes structure for table article
-- ----------------------------
CREATE INDEX "idx_article_aid_del" ON "public"."article" USING btree (
  "aid" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "deleted" "pg_catalog"."bool_ops" ASC NULLS LAST
);
CREATE INDEX "idx_article_vector" ON "public"."article" USING gin (
  "vector" "pg_catalog"."tsvector_ops"
);

-- ----------------------------
-- Primary Key structure for table article
-- ----------------------------
ALTER TABLE "public"."article" ADD CONSTRAINT "article_pkey" PRIMARY KEY ("aid");
