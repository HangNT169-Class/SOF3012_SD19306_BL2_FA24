select * from category
ORDER BY id 
OFFSET 4 ROWS 
FETCH NEXT 4 ROWS ONLY
select * from category
ORDER BY id 
OFFSET 4 ROWS -- Bo qua phan tu o vi tri offset => tien den offset + 1
FETCH NEXT 4 ROWS ONLY -- Lay so luong phan tu 
-- trang dau tien: Bat dau la 0 
-- trang dau tien 0: so trang * so phan tu 
-- offset: 0 * 3 = 0 : 123
-- 1 * 3 = 3 : 456
-- 2 * 3 = 6 : 789 
-- 1 - 5
-- pageSize : soLuong phan tu cua 1 trang 
-- pageNumber : so trang
-- 10 phan tu : 3 pt 1 trang => 4 trang
-- TS1: 3 
-- TS2: 3
-- TS3: 3
-- TS4: 1
-- Moi trang co 3 phan tu => So luong phan tu cua 1 trang
-- Trang dau tien
-- Trang dau tien bat dau bang 0: 123 (offset: 0 )
-- Trang thu 1: 456 (offset : 3)
-- Trang thu 2: 789 (offset: 6)
-- offset: pageNo * pageSize : 
-- 0: 0 * 3 
-- 1: 1 * 3
-- 2: 2 * 3
-- 3: 3 * 3
select * from category
ORDER BY id
OFFSET 5 ROWS
FETCH NEXT 5 ROWS ONLY
-- 0 - 5:  1 
-- 6 - 10 : 2
