-- 카테고리 데이터 저장
INSERT INTO category(name, type) VALUES ('식품', 'A');
INSERT INTO category(name, type) VALUES('화장품', 'B');
INSERT INTO category(name, type) VALUES('식당', 'C');

-- 상점 데이터 저장
-- 업종 식품
insert into partner (name, category_id) VALUES('과일판매점', 1);
insert into partner (name, category_id) VALUES('정육점', 1);

-- 업종 화장품
insert into partner(name, category_id)VALUES('화장품', 2);
insert into partner(name, category_id)VALUES('식당', 2);

-- 업종 식당
insert into partner(name, category_id)VALUES('중국집', 3);
insert into partner(name, category_id)VALUES('분식', 3);