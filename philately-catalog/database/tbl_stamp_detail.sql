CREATE TABLE tbl_stamp_detail (
  tbl_stamp_detail_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tbl_user_catalog_id INTEGER UNSIGNED NOT NULL,
  tbl_user_catalog_tbl_user_id INTEGER UNSIGNED NOT NULL,
  tbl_user_catalog_tbl_user_tbl_country_id INTEGER UNSIGNED NOT NULL,
  tbl_stamp_condition_id INTEGER UNSIGNED NOT NULL,
  tbl_stamp_gum_condition_id INTEGER UNSIGNED NOT NULL,
  tbl_first_day_cover_id INTEGER UNSIGNED NOT NULL,
  tbl_stamp_tbl_country_id INTEGER UNSIGNED NOT NULL,
  tbl_stamp_tbl_currency_id INTEGER UNSIGNED NOT NULL,
  tbl_stamp_tbl_theme_id INTEGER UNSIGNED NOT NULL,
  tbl_stamp_id INTEGER UNSIGNED NOT NULL,
  tbl_stamp_detail_stamp_id INTEGER UNSIGNED NULL,
  tbl_stamp_detail_gum_condition_id INTEGER UNSIGNED NULL,
  tbl_stamp_detail_purchased_price FLOAT NULL,
  tbl_stamp_detail_current_value FLOAT NULL,
  tbl_stamp_detail_date_acquired DATE NULL,
  tbl_stamp_detail_location VARCHAR(255) NULL,
  tbl_stamp_detail_mint_value FLOAT NULL,
  tbl_stamp_detail_used_value FLOAT NULL,
  tbl_stamp_detail_value_in_currency_id INTEGER UNSIGNED NULL,
  tbl_stamp_detail_first_day_cover_id INTEGER UNSIGNED NULL,
  tbl_stamp_detail_condition_id INTEGER UNSIGNED NULL,
  PRIMARY KEY(tbl_stamp_detail_id, tbl_user_catalog_id, tbl_user_catalog_tbl_user_id, tbl_user_catalog_tbl_user_tbl_country_id, tbl_stamp_condition_id, tbl_stamp_gum_condition_id, tbl_first_day_cover_id),
  INDEX tbl_stamp_detail_FKIndex1(tbl_stamp_id, tbl_stamp_tbl_theme_id, tbl_stamp_tbl_currency_id, tbl_stamp_tbl_country_id),
  INDEX tbl_stamp_detail_FKIndex2(tbl_user_catalog_id, tbl_user_catalog_tbl_user_id, tbl_user_catalog_tbl_user_tbl_country_id),
  INDEX tbl_stamp_detail_FKIndex3(tbl_stamp_condition_id),
  INDEX tbl_stamp_detail_FKIndex4(tbl_stamp_gum_condition_id),
  INDEX tbl_stamp_detail_FKIndex5(tbl_first_day_cover_id)
);

INSERT INTO tbl_stamp_detail (tbl_stamp_detail_id, tbl_user_catalog_id, tbl_user_catalog_tbl_user_id, tbl_user_catalog_tbl_user_tbl_country_id, tbl_stamp_condition_id, tbl_stamp_gum_condition_id, tbl_first_day_cover_id, tbl_stamp_tbl_country_id, tbl_stamp_tbl_currency_id, tbl_stamp_tbl_theme_id, tbl_stamp_id, tbl_stamp_detail_stamp_id, tbl_stamp_detail_gum_condition_id, tbl_stamp_detail_purchased_price, tbl_stamp_detail_current_value, tbl_stamp_detail_date_acquired, tbl_stamp_detail_location, tbl_stamp_detail_mint_value, tbl_stamp_detail_used_value, tbl_stamp_detail_value_in_currency_id, tbl_stamp_detail_first_day_cover_id, tbl_stamp_detail_condition_id) VALUES()

DROP TABLE tbl_stamp_detail;