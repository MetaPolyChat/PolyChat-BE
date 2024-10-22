# INSERT INTO tbl_user (email, password, planet, user_name, authority, login_type, status) VALUES
#                                                                                              ('admin1@example.com', 'password123', 'Earth', 'AdminOne', 'ADMIN', 'NONE', 'ACTIVATED'),
#                                                                                              ('admin2@example.com', 'password123', 'Mars', 'AdminTwo', 'ADMIN', 'NONE', 'ACTIVATED'),
#                                                                                              ('admin3@example.com', 'password123', 'Jupiter', 'AdminThree', 'ADMIN', 'NONE', 'ACTIVATED'),
#                                                                                              ('admin4@example.com', 'password123', 'Venus', 'AdminFour', 'ADMIN', 'NONE', 'ACTIVATED'),
#
#                                                                                              ('user1@gmail.com', 'userpass1', 'Saturn', 'Skywalker21', 'USER', 'GOOGLE', 'ACTIVATED'),
#                                                                                              ('user2@gmail.com', 'userpass2', 'Neptune', 'ShadowHunter', 'USER', 'GOOGLE', 'BEFORE_SIGNUP'),
#                                                                                              ('user3@gmail.com', 'userpass3', 'Uranus', 'PhoenixBlade', 'USER', 'GOOGLE', 'DEACTIVATED'),
#                                                                                              ('user4@gmail.com', 'userpass4', 'Mercury', 'NightWolf', 'USER', 'GOOGLE', 'SUSPENDED'),
#                                                                                              ('user5@gmail.com', 'userpass5', 'Pluto', 'SilverArrow', 'USER', 'GOOGLE', 'ACTIVATED'),
#                                                                                              ('user6@gmail.com', 'userpass6', 'Vulcan', 'BlueDragon', 'USER', 'GOOGLE', 'ACTIVATED'),
#                                                                                              ('user7@gmail.com', 'userpass7', 'Naboo', 'IronTiger', 'USER', 'GOOGLE', 'BEFORE_SIGNUP'),
#                                                                                              ('user8@gmail.com', 'userpass8', 'Tatooine', 'MysticWarrior', 'USER', 'GOOGLE', 'DEACTIVATED'),
#                                                                                              ('user9@gmail.com', 'userpass9', 'Krypton', 'DarkVortex', 'USER', 'GOOGLE', 'SUSPENDED'),
#                                                                                              ('user10@gmail.com', 'userpass10', 'Gallifrey', 'StormRider', 'USER', 'GOOGLE', 'ACTIVATED'),
#                                                                                              ('user11@gmail.com', 'userpass11', 'Pandora', 'CrystalMage', 'USER', 'GOOGLE', 'ACTIVATED'),
#                                                                                              ('user12@gmail.com', 'userpass12', 'Vulcan', 'RedFalcon', 'USER', 'GOOGLE', 'BEFORE_SIGNUP'),
#                                                                                              ('user13@gmail.com', 'userpass13', 'Dagobah', 'BlackPanther', 'USER', 'GOOGLE', 'DEACTIVATED'),
#                                                                                              ('user14@gmail.com', 'userpass14', 'Endor', 'SilverHawk', 'USER', 'GOOGLE', 'SUSPENDED'),
#                                                                                              ('user15@gmail.com', 'userpass15', 'Mustafar', 'GoldenKnight', 'USER', 'GOOGLE', 'ACTIVATED'),
#                                                                                              ('user16@gmail.com', 'userpass16', 'Coruscant', 'ThunderFury', 'USER', 'GOOGLE', 'ACTIVATED');



INSERT INTO tbl_user (email, password, planet, user_name, authority, login_type, status, created_at)
VALUES
    ('admin1@example.com', 'password123', 'Earth', 'AdminOne', 'ADMIN', 'NONE', 'ACTIVATED', '2024-09-23 10:15:00'),
    ('admin2@example.com', 'password123', 'Mars', 'AdminTwo', 'ADMIN', 'NONE', 'ACTIVATED', '2024-09-24 11:30:00'),
    ('admin3@example.com', 'password123', 'Jupiter', 'AdminThree', 'ADMIN', 'NONE', 'ACTIVATED', '2024-09-25 14:45:00'),
    ('admin4@example.com', 'password123', 'Venus', 'AdminFour', 'ADMIN', 'NONE', 'ACTIVATED', '2024-09-26 09:20:00'),

    ('user1@gmail.com', 'userpass1', 'Saturn', 'Skywalker21', 'USER', 'GOOGLE', 'ACTIVATED', '2024-09-27 16:10:00'),
    ('user2@gmail.com', 'userpass2', 'Neptune', 'ShadowHunter', 'USER', 'GOOGLE', 'BEFORE_SIGNUP', '2024-09-28 17:25:00'),
    ('user3@gmail.com', 'userpass3', 'Uranus', 'PhoenixBlade', 'USER', 'GOOGLE', 'DEACTIVATED', '2024-09-29 13:50:00'),
    ('user4@gmail.com', 'userpass4', 'Mercury', 'NightWolf', 'USER', 'GOOGLE', 'SUSPENDED', '2024-09-30 12:30:00'),
    ('user5@gmail.com', 'userpass5', 'Pluto', 'SilverArrow', 'USER', 'GOOGLE', 'ACTIVATED', '2024-10-01 08:45:00'),
    ('user6@gmail.com', 'userpass6', 'Vulcan', 'BlueDragon', 'USER', 'GOOGLE', 'ACTIVATED', '2024-10-02 14:20:00'),
    ('user7@gmail.com', 'userpass7', 'Naboo', 'IronTiger', 'USER', 'GOOGLE', 'BEFORE_SIGNUP', '2024-10-03 18:55:00'),
    ('user8@gmail.com', 'userpass8', 'Tatooine', 'MysticWarrior', 'USER', 'GOOGLE', 'DEACTIVATED', '2024-10-04 09:40:00'),
    ('user9@gmail.com', 'userpass9', 'Krypton', 'DarkVortex', 'USER', 'GOOGLE', 'SUSPENDED', '2024-10-05 10:35:00'),
    ('user10@gmail.com', 'userpass10', 'Gallifrey', 'StormRider', 'USER', 'GOOGLE', 'ACTIVATED', '2024-10-06 15:10:00'),
    ('user11@gmail.com', 'userpass11', 'Pandora', 'CrystalMage', 'USER', 'GOOGLE', 'ACTIVATED', '2024-10-07 19:25:00'),
    ('user12@gmail.com', 'userpass12', 'Vulcan', 'RedFalcon', 'USER', 'GOOGLE', 'BEFORE_SIGNUP', '2024-10-08 13:00:00'),
    ('user13@gmail.com', 'userpass13', 'Dagobah', 'BlackPanther', 'USER', 'GOOGLE', 'DEACTIVATED', '2024-10-09 17:40:00'),
    ('user14@gmail.com', 'userpass14', 'Endor', 'SilverHawk', 'USER', 'GOOGLE', 'SUSPENDED', '2024-10-10 09:15:00'),
    ('user15@gmail.com', 'userpass15', 'Mustafar', 'GoldenKnight', 'USER', 'GOOGLE', 'ACTIVATED', '2024-10-11 14:50:00'),
    ('user16@gmail.com', 'userpass16', 'Coruscant', 'ThunderFury', 'USER', 'GOOGLE', 'ACTIVATED', '2024-10-15 18:00:00');

INSERT INTO polychatdb.tbl_friend (user1, user2) VALUES (5, 6);
INSERT INTO polychatdb.tbl_friend (user1, user2) VALUES (6, 5);
INSERT INTO polychatdb.tbl_friend (user1, user2) VALUES (6, 7);
INSERT INTO polychatdb.tbl_friend (user1, user2) VALUES (7, 6);
INSERT INTO polychatdb.tbl_friend (user1, user2) VALUES (8, 7);
INSERT INTO polychatdb.tbl_friend (user1, user2) VALUES (7, 8);
INSERT INTO polychatdb.tbl_friend (friend_id, user1, user2) VALUES (1111, 1, 2);


INSERT INTO polychatdb.tbl_friend_request (receiver, sender, status) VALUES (9, 10, 0);
INSERT INTO polychatdb.tbl_friend_request (receiver, sender, status) VALUES (12, 11, 0);


INSERT INTO polychatdb.tbl_announcement (last_updated_time, upload_time, uploader_id, announcement_content, announcement_title) VALUES ('2024-08-26 09:03:05.916479', '2024-08-24 13:19:00.000000', 1, '몇시부터 몇시까지는 점검 예정', '점검 시간 안내');
INSERT INTO polychatdb.tbl_announcement (last_updated_time, upload_time, uploader_id, announcement_content, announcement_title) VALUES ('2024-08-26 09:03:06.225015', '2024-08-26 09:03:00.970191', 3, '매너를 지켜서 활동하기', '주의 사항 안내');
INSERT INTO polychatdb.tbl_announcement (last_updated_time, upload_time, uploader_id, announcement_content, announcement_title) VALUES ('2024-09-12 11:03:06.733324', '2024-09-12 11:03:06.733324', 2, '추후 업데이트 진행 예정', '서비스 업데이트 안내');



INSERT INTO polychatdb.tbl_achievement (achievement_active, achievement_condition,
                                        achievement_description, achievement_icon_url, achievement_name)
VALUES  ('Y', '1주 연속 접속' , '1주 연속으로 폴리챗에 방문', null, '꾸준러');


INSERT INTO tbl_block_list (blocked_user_id, created_at, user_id) VALUES
                                                                      (7, '2024-09-19 10:15:32', 5),
                                                                      (10, '2024-09-20 14:22:45', 6),
                                                                      (15, '2024-09-21 09:35:12', 8),
                                                                      (19, '2024-09-21 18:47:55', 12),
                                                                      (20, '2024-09-22 12:05:21', 17);


INSERT INTO tbl_item (item_name, item_description, item_type, price, item_image_url, created_at)
VALUES
    ('나무 의자', '따뜻한 느낌의 나무 의자입니다.', '가구', 850, NULL, '2024-10-07 10:15:30'),
    ('꽃무늬 테이블', '작은 꽃무늬가 새겨진 예쁜 테이블입니다.', '가구', 720, NULL, '2024-10-08 11:00:00'),
    ('구름 소파', '구름처럼 푹신한 소파입니다.', '가구', 950, NULL, '2024-10-09 09:30:45'),
    ('하얀 침대', '편안한 하얀색 침대입니다.', '가구', 980, NULL, '2024-10-10 14:25:20'),
    ('별 조명', '은은하게 빛나는 별 모양 조명입니다.', '장식', 430, NULL, '2024-10-11 16:45:50'),
    ('책장', '책을 보관할 수 있는 깔끔한 책장입니다.', '가구', 890, NULL, '2024-10-12 13:15:10'),
    ('양탄자', '부드럽고 따뜻한 느낌의 양탄자입니다.', '장식', 600, NULL, '2024-10-14 08:20:35'),
    ('초록 식물', '싱그러운 초록 식물 화분입니다.', '장식', 480, NULL, '2024-10-15 18:05:00'),
    ('벽시계', '시간을 확인할 수 있는 간단한 벽시계입니다.', '장식', 250, NULL, '2024-10-17 11:30:45'),
    ('캔들 홀더', '아늑한 분위기를 만들어주는 캔들 홀더입니다.', '장식', 310, NULL, '2024-10-21 09:50:00');
