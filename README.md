# evolent
Java developer assignment 
tools used intellIJ and gradle 5.6.1 configure code in intellij IDEA using build.gradle file.
REST apis are developed using spring boot.
HTTP urls:- get All Contact http://localhost:8080/contact

create new contact POST api =>http://localhost:8080/contact 
request { firstName:"akash", lastName:"Surwase", email:"akash@bt.com", phoneNumber:"8149150138", status:"Active", } 
update existing contact 
PUT api => http://localhost:8080/contact
{ id : "1", firstName:"akash-updated", lastName:"Surwase", email:"akash@bt.com", phoneNumber:"8149150138", status:"Active" }

delete contact
Delete api =>http://localhost:8080/contact/{id}
