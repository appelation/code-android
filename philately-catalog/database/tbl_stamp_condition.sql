CREATE TABLE `tbl_stamp_condition` (
	`tbl_stamp_condition_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`tbl_stamp_condition_code`	TEXT NOT NULL,
	`tbl_stamp_condition_desc`	TEXT NOT NULL
);

INSERT INTO tbl_stamp_condition (tbl_stamp_condition_code, tbl_stamp_condition_desc) VALUES('XF', 'Extra fine (EF) or Extremely fine (XF)');
INSERT INTO tbl_stamp_condition (tbl_stamp_condition_code, tbl_stamp_condition_desc) VALUES('S', 'Superb (S)');
INSERT INTO tbl_stamp_condition (tbl_stamp_condition_code, tbl_stamp_condition_desc) VALUES('VF', 'Very fine (VF)');
INSERT INTO tbl_stamp_condition (tbl_stamp_condition_code, tbl_stamp_condition_desc) VALUES('F-VF', 'Fine-Very fine (F-VF)');
INSERT INTO tbl_stamp_condition (tbl_stamp_condition_code, tbl_stamp_condition_desc) VALUES('A', 'Average (Avg.)');
INSERT INTO tbl_stamp_condition (tbl_stamp_condition_code, tbl_stamp_condition_desc) VALUES('F', 'Fine (F)');
INSERT INTO tbl_stamp_condition (tbl_stamp_condition_code, tbl_stamp_condition_desc) VALUES('P', 'Poor (P)');

-- select * from tbl_stamp_condition;

DROP TABLE tbl_stamp_condition;
