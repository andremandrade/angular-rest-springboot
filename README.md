# Angular + Rest + Spring Boot - Example

### API URI: http://localhost:8080/rest/v1/</h1>

#### Equipment Resource

|RESOURCE URI             | Methods | Description	                             |
|:-----------------------:|---------|------------------------------------------------|
| /equip/     		  | GET     | List all equipments        		     |
| /equip/{id} 		  | GET     | Returns an equipment by id 		     |
| /equip/     		  | POST    | Create new equipment       		     |
| /equip/      		  | PUT     | Update equipment by id     		     |
| /equip/{id}/capability/ | GET     | Returns capabilities of equipment by id        |
| /equip/{id}/capability/ | POST    | Add a capability to the equipment with id={id} |


#### Product Resource 

|RESOURCE URI | Supported Methods | Description	       |
|:-----------:|-------------------|--------------------|
| /product/   | GET               | List all products  |
| /product/   | POST              | Create new product |


