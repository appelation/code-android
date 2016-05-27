CREATE TABLE "tbl_user" (
  `tbl_user_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `tbl_user_firstname`  TEXT NOT NULL,
  `tbl_user_lastname` TEXT NOT NULL,
  `tbl_user_email`  TEXT NOT NULL,
  `tbl_user_pwd`  TEXT NOT NULL,
  `tbl_user_phone`  TEXT,
  `tbl_user_country_id` INTEGER NOT NULL,
  `tbl_user_status` INTEGER NOT NULL
);


INSERT INTO tbl_user (tbl_user_id, tbl_country_id, tbl_user_firstname, tbl_user_lastname, tbl_user_email, tbl_user_pwd, tbl_user_phone, tbl_user_country_id) VALUES()

DROP TABLE tbl_user;


