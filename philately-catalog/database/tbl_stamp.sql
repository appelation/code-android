CREATE TABLE tbl_stamp (
  tbl_stamp_id INTEGER NOT NULL AUTOINCREMENT,
  tbl_stamp_title VARCHAR(255) NOT NULL,
  tbl_stamp_desc VARCHAR(500) NULL,
  tbl_stamp_country_id INTEGER NULL,
  tbl_stamp_denomination FLOAT NOT NULL,
  tbl_stamp_currency_id VARCHAR(4) NULL,
  tbl_stamp_date_of_issue DATE NULL,
  tbl_stamp_perforations FLOAT NULL,
  tbl_stamp_sheet_size VARCHAR(20) NULL,
  tbl_stamp_sheets_issued VARCHAR(20) NULL,
  tbl_stamp_design VARCHAR(255) NULL,
  tbl_stamp_height_in_mm INTEGER NULL,
  tbl_stamp_width_in_mm INTEGER NULL,
  tbl_stamp_catalog_no VARCHAR(10) NULL,
  tbl_stamp_colors VARCHAR(255) NULL,
  tbl_stamp_paper_color VARCHAR(20) NULL,
  tbl_stamp_series VARCHAR(20) NULL,
  tbl_stamp_plate_no VARCHAR(20) NULL,
  tbl_stamp_watermark VARCHAR(50) NULL,
  tbl_stamp_image_url VARCHAR(255) NULL,
  tbl_stamp_theme_id INTEGER NULL,
  tbl_stamp_engraved_by VARCHAR(255) NULL,
  tbl_stamp_language_id INTEGER NULL,
  tbl_stamp_scott_no VARCHAR(20) NULL,
  tbl_stamp_illustration_no VARCHAR(20) NULL,
  tbl_stamp_group_id VARCHAR(20) NULL,
  tbl_stamp_is_setenant  BIT NULL,
  tbl_stamp_paper_type VARCHAR(20) NULL,
  tbl_stamp_separation VARCHAR(20) NULL,
  tbl_stamp_printing_process VARCHAR(50) NULL,
  tbl_stamp_printed_by VARCHAR(50) NULL,
  PRIMARY KEY(tbl_stamp_id)
);

INSERT INTO tbl_stamp (tbl_stamp_id, tbl_theme_id, tbl_currency_id, tbl_country_id, tbl_stamp_title, tbl_stamp_desc, tbl_stamp_country_id, tbl_stamp_denomination, tbl_stamp_currency_id, tbl_stamp_date_of_issue, tbl_stamp_perforations, tbl_stamp_sheet_size, tbl_stamp_sheets_issued, tbl_stamp_design, tbl_stamp_height_in_mm, tbl_stamp_width_in_mm, tbl_stamp_catalog_no, tbl_stamp_colors, tbl_stamp_paper_color, tbl_stamp_series, tbl_stamp_plate_no, tbl_stamp_watermark, tbl_stamp_image_url, tbl_stamp_theme_id, tbl_stamp_engraved_by, tbl_stamp_language_id, tbl_stamp_scott_no, tbl_stamp_illustration_no, tbl_stamp_group_id, tbl_stamp_is_setenant , tbl_stamp_paper_type, tbl_stamp_separation, tbl_stamp_printing_process, tbl_stamp_printed_by) VALUES()

DROP TABLE tbl_stamp;