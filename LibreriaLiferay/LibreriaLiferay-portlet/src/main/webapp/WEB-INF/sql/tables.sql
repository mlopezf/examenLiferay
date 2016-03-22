create table LibreriaLiferay_Usuario (
	userId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);