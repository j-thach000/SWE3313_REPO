BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Checkout" (
	"OrderID"	INTEGER,
	"FormOfPay"	TEXT NOT NULL,
	"Address"	TEXT,
	"subtotal"	DECIMAL(18, 2) NOT NULL,
	"tax"	DECIMAL(18, 2) NOT NULL,
	"Total"	DECIMAL(18, 2) NOT NULL,
	"Datetime"	DATETIME,
	"customerNum"	TEXT,
	PRIMARY KEY("OrderID"),
	FOREIGN KEY("customerNum") REFERENCES "Customer"("Phone_num")
);
CREATE TABLE IF NOT EXISTS "Customer" (
	"Phone_num"	TEXT,
	"Fname"	TEXT NOT NULL,
	"Lname"	TEXT NOT NULL,
	PRIMARY KEY("Phone_num")
);
CREATE TABLE IF NOT EXISTS "History" (
	"OrderID"	INTEGER,
	"Customer_num"	TEXT,
	"Address"	TEXT NOT NULL,
	"DateTime"	DATETIME NOT NULL,
	"Total"	DECIMAL(18, 2) NOT NULL,
	PRIMARY KEY("OrderID","Customer_num"),
	FOREIGN KEY("Customer_num") REFERENCES "Customer"("Phone_num"),
	FOREIGN KEY("OrderID") REFERENCES "Checkout"("OrderID")
);
CREATE TABLE IF NOT EXISTS "Items" (
	"ItemID"	INTEGER,
	"Item_Name"	TEXT,
	"ImageFile"	TEXT,
	"Price"	DECIMAL(18, 2) NOT NULL,
	"Default_Amount"	INTEGER NOT NULL,
	PRIMARY KEY("ItemID")
);
CREATE TABLE IF NOT EXISTS "Options" (
	"OptionID"	INTEGER,
	"OptionType"	TEXT NOT NULL,
	"OptionName"	TEXT NOT NULL,
	"OptionCost"	DECIMAL(18, 2) NOT NULL,
	PRIMARY KEY("OptionID")
);
CREATE TABLE IF NOT EXISTS "OptionsAss" (
	"OrderID"	INTEGER,
	"ProductID"	INTEGER,
	"OptionsID"	INTEGER,
	PRIMARY KEY("OrderID","ProductID","OptionsID"),
	FOREIGN KEY("OptionsID") REFERENCES "Options"("OptionID"),
	FOREIGN KEY("OrderID") REFERENCES "Checkout"("OrderID"),
	FOREIGN KEY("ProductID") REFERENCES "Items"("ItemID")
);
COMMIT;
