# form-in-spring
CRUD operation to database in simple form

This is my old project. The project contains one main commit that adds the whole project. The whole story is on my BitBucket. I decided so because it contained commits that kept the state of the application down (which I think is not good) and a description of the problems and the reason for using the solution.
Used technologies:
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- Lombok
- MySQL
- Thymeleaf
- SQL
- JavaScript, jQuery
- HTML, CSS

Data generated at https://www.generatedata.com/#t1

# To do:

## Pagination of pages
- [x] The entry to the page starts from the page pagination by default
- [x] The Cancel operation on the form when adding and updating data should transfer to the previous pagination page
- [x] When sorting, the returned result should be displayed in pagination of pages in the main URL path
- [x] When sorting data, switching to the next page of pagination should keep the table in the form sorted after the selected sort criterion
- [x] Sorting on any page of pagination can not redirect to the first pagination page, the current subpage must be updated with the appropriate sort result
- [x] After switching to the next subpage of searched results, these should be the next searched phrases
- [x] After deleting all records from a given sub-page, the table's header itself is displayed - to redirect in this case to the page with records

## Search
- [x] The ability to search data for part of the expression, e.g. 'What', 'what', 'Comp', 'any', 'pan', 'PANY', 'cOmPa', etc. should return, among others, CompanyOne and JavaCompany and other matching expressions, exactly the same case for searching on the fields vatId and regNo
- [x] Data search should be returned in pagination of pages
- [x] The search result should be returned in the main URL path (without redirecting to another subpage)
- [x] The ability to search by clicking the mouse in the buton and not exclusively by enter
- [x] If the given data was not found information about it instead of the table header only

## Addition, Data update
- [x] Ability to add and update data
- [ ] Adding multiple addresses and contacts to one client

## Data removal
- [x] All related data should be removed from all tables in the database and not only from one
- [ ] In the message confirming the deletion of data should be given the name of the client from the field Client.name
- [ ] Deleting a position from the current pagination subpage can not redirect to the first pagination page - it must be the current subpage from which the record is removed

## Error handling
- [x] Error message page instead of the standard server error message

---

![1](https://user-images.githubusercontent.com/26818304/53264716-94489300-36dc-11e9-99dd-42aa3bebbea4.PNG)
![2](https://user-images.githubusercontent.com/26818304/53264717-94e12980-36dc-11e9-8e3c-d94b5d860eb2.PNG)
![3](https://user-images.githubusercontent.com/26818304/53266956-85fd7580-36e2-11e9-8260-7e632fc9f664.PNG)
