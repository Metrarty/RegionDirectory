DROP TABLE IF EXISTS REGION;
CREATE TABLE REGION (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   region_name VARCHAR(255),
   short_region_name VARCHAR(255)
);