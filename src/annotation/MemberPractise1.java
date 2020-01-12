package annotation;
class Photo{}
@DBTable(name = "MEMBER")
public class MemberPractise1 {
	@SQLString(30) 
	String firstName;
	@SQLString(50)
	String lastName;
	@SQLInteger
	Integer age;
	@SQLString(value = 30,constraints = @Constraints(primaryKey = true))
	String handle;
	@SQLBoolean
	Boolean	newMemberStatus;
	@SQLVarChar
	String address;
	@SQLDateTime
	String dateTime;
	@SQLBlob
	Photo photo;
	
	static int memberCount;
	public String getHandle() {return handle;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String toString() {return handle;}
	public Integer getAge() {return age;}
	public Boolean getNewMemberStatus(){return newMemberStatus;}
	public String getAddress(){return address;}
	public Photo getPhoto(){return photo;}
}
