CREATE TABLE tbl_user_catalog (
  tbl_user_catalog_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tbl_user_id INTEGER UNSIGNED NOT NULL,
  tbl_user_tbl_country_id INTEGER UNSIGNED NOT NULL,
  tbl_user_catalog_user_id INTEGER UNSIGNED NULL,
  tbl_user_catalog_stamp_detail_id INTEGER UNSIGNED NULL,
  PRIMARY KEY(tbl_user_catalog_id, tbl_user_id, tbl_user_tbl_country_id),
  INDEX tbl_user_catalog_FKIndex1(tbl_user_id, tbl_user_tbl_country_id)
);

INSERT INTO tbl_user_catalog (tbl_user_catalog_id, tbl_user_id, tbl_user_tbl_country_id, tbl_user_catalog_user_id, tbl_user_catalog_stamp_detail_id) VALUES();

DROP TABLE tbl_user_catalog;
