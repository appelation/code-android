CREATE TABLE `tbl_stamp_gum_condition` (
	`tbl_stamp_gum_condition_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`tbl_stamp_gum_condition_code`	TEXT NOT NULL,
	`tbl_stamp_gum_condition_desc`	TEXT NOT NULL
);

INSERT INTO tbl_stamp_gum_condition (tbl_stamp_gum_condition_code, tbl_stamp_gum_condition_desc) VALUES('MNH', 'Mint never-hinged (MNH or Mint NH, NH)');
INSERT INTO tbl_stamp_gum_condition (tbl_stamp_gum_condition_code, tbl_stamp_gum_condition_desc) VALUES('LH', 'Lightly hinged (LH)');
INSERT INTO tbl_stamp_gum_condition (tbl_stamp_gum_condition_code, tbl_stamp_gum_condition_desc) VALUES('HH', 'Heavily hinged (HH) ');
INSERT INTO tbl_stamp_gum_condition (tbl_stamp_gum_condition_code, tbl_stamp_gum_condition_desc) VALUES('HR', 'Hinge remaining (HR)');
INSERT INTO tbl_stamp_gum_condition (tbl_stamp_gum_condition_code, tbl_stamp_gum_condition_desc) VALUES('OG', 'Original gum (OG)');
INSERT INTO tbl_stamp_gum_condition (tbl_stamp_gum_condition_code, tbl_stamp_gum_condition_desc) VALUES('NG', 'No Gum (NG)');
INSERT INTO tbl_stamp_gum_condition (tbl_stamp_gum_condition_code, tbl_stamp_gum_condition_desc) VALUES('RG', 'Regummed (RG)');

-- select * from tbl_stamp_gum_condition;

DROP TABLE tbl_stamp_gum_condition;

