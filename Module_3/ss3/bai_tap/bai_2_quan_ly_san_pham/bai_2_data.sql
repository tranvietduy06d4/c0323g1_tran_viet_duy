use quan_ly_ban_hang;

INSERT INTO customer 
  (cID,cName,cAge)
VALUES 
  (1,'Minh Quan',10),
  (2,'Ngoc Oanh',20),
  (3,'Hong Ha',50);
  

INSERT INTO `order`
  (oID,cID,oDate,oTotalPrice) 
VALUES 
  (1,1,'2006-03-21',Null),
  (2,2,'2006-03-23',Null),
  (3,1,'2006-03-16',Null);
  
 
INSERT INTO product 
  (pID,pName,pPrice) 
VALUES 
  (1,'May Giat',3),
  (2,'Tu Lanh',5),
  (3,'Dieu Hoa',7),
  (4,'Quat',1),
  (5,'Bep Dien',2);
  

INSERT INTO order_detail 
  (odQuantity,oID,pID) 
VALUES 
  (3,1,1),
  (7,1,3),
  (2,1,4),
  (1,2,1),
  (8,3,1),
  (4,2,5),
  (3,2,3);
  
  