import java.util.*;
class list extends node
{
    node start,nptr,temp;
    public void screen()
    {
        System.out.println("                      ..................CONTACT LIST.....................");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("     TOTAL CONTACT: "+count());
    }
    public int count()
    {
        temp=new node();
        if(check()==-1)
        {
            return 0;
        }
        else
        {
            temp=start;
            int i=0;
            while(temp.link!=null)
            {
                i++;
            }
            return i;
        }
    }
    public list()
    {
        start=new node();
        nptr=new node();
    }
    public int check()
    {
        if(start==null)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    public void add_name(String str,String num)
    {
        temp=new node();
        temp.link=null;
        temp.name=str;
        temp.number=num;
        if(start==null)
        {
            start=temp;
            nptr=temp;
        }
        else
        {
            nptr.link=temp;
            nptr=temp;
        }
    }
    public void add_addr(String str)
    {
        if(check()==-1)
        {
            System.out.println("FIRST CREATE A CONTACT");
        }
        else
        {
            nptr.addr=str;
        }
    }
    public void add_notes(String str)
    {
        if(check()==-1)
        {
            System.out.println("FIRST CREATE A CONTACT");
        }
        else
        {
            nptr.notes=str;
        }
    }
    public int display(String str)
    {
        temp=new node();
        temp=start;
        int i=0,k=0;
        int op=check();
        if(op==1)
        {
            
        while(temp.link!=null)
        {
            i++;
            temp=temp.link;
            if(temp.name.equalsIgnoreCase(str))
            {
                System.out.println("NAME : "+temp.name);
                System.out.println("NUMBER IS : "+temp.number);
                System.out.println("ADDRESS : "+temp.addr);
                System.out.println("NOTES : "+temp.notes);
                k=1;
            }
        }
        if(k==0)
        {
            return -1;
        }
        else
        {
            return i-1;
        }
    }
    else
    {
        System.out.println("CONTACT LIST IS EMPTY");
        return -1;
    }
    }
    public void sort()
    {
        temp=new node();
        temp=start;
        int ell=check();
        if(ell==1)
        {
        while(temp.link!=null)
        {
            node extra=new node();
            extra=temp.link;
            String op=extra.name;
            if(temp.name.compareTo(op)>1)
            {
                String lol=temp.name;
                temp.name=op;
                extra.name=lol;
            }
            temp=temp.link;
        }
    }
    else
    {
        System.out.println("CONTACT LIST IS EMPTY");
    }
    }
    public void display_all()
    {
        temp=new node();
        temp=start;
        int op=check();
        if(op==1)
        {
        while(temp.link!=null)
        {
            String str=temp.name;
            int r=display(str);
            temp=temp.link;
        }
    }
    else
    {
        System.out.println("CONTACT LIST IS EMPTY");
    }
}
public void modify(String str)
{
    Scanner sc=new Scanner(System.in);
    int res=display(str);
    temp=new node();
    temp=start;
    if(res==-1)
    {
        System.out.println("CONTACT NOT FOUND ");
    }
    else
    {
        while(temp.link!=null)
        {
            temp=temp.link;
            if(temp.name.equalsIgnoreCase(str))
            {
                break;
            }
        }
        System.out.println("1 to modify name \n 2 to modify address \n 3 to modify note \n 4 to modify number ");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
            System.out.println("ENTER NEW NAME ");
            String extra=sc.nextLine();
            temp.name=extra;
            break;
            case 2:
            System.out.println("ENTER NEW ADDRESS ");
            String extra1=sc.nextLine();
            temp.addr=extra1;
            break;
            case 3:
            System.out.println("ENTER NEW NOTE FOR CONTACT");
            String extra2=sc.nextLine();
            temp.notes=extra2;
            break;
            case 4:
            System.out.println("ENTER NEW NUMBER ");
            String extra3=sc.nextLine();
            temp.number=extra3;
            break;
            default :
            System.out.println("WRONG INPUT press 1 to retry ");
            int choice2=sc.nextInt();
            if(choice2==1)
            {
                modify(str);
            }
        }
        System.out.println(" DATA MODIFIED ");
    }
}
public static void main()
{
    Scanner sc=new Scanner(System.in);
    list admin=new list();
    System.out.println("                        ............CONTACT LIST...............");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println(" ADD A CONTACT press any key ");
    String str1=sc.nextLine();
    int choice=-1;
    while(choice!=5)
    {
        System.out.println("PRESS 1 TO ENTER CONTACT \n PRESS 2 TO DISPLAY ALL CONTACT \n PRESS 3 TO SEARCH A CONTACT \n PRESS 4 TO MODIFY LIST \n PRESS 5 TO EXIT");
    choice=sc.nextInt();
    switch(choice)
    {
        case 1:
        int choice1=1;
    while(choice1!=2)
    {
    System.out.println("PRESS 1 TO ENTER CONTACT \n PRESS 2 TO STOP");
    choice1=sc.nextInt();
    if(choice1==2)
    {
        break;
    }
    String dr=sc.nextLine();
    System.out.println("ENTER THE NUMBER");
    String num=sc.nextLine();
    System.out.println("ENTER THE NAME ");
    String nm1=sc.nextLine();
    admin.add_name(nm1,num);
    System.out.println("ENTER THE ADDRESS OR PRESS RENTER");
    String addr4=sc.nextLine();
    admin.add_addr(addr4);
    System.out.println("ENTER THE NOTE OR PRESS RENTER");
    String note4=sc.nextLine();
    admin.add_notes(note4);
    System.out.println(" DATA ENTERED ");
    System.out.println(" \f");
    admin.screen();
    admin.sort();
}
break;
case 2:
admin.display_all();
break;
case 3:
System.out.println("ENTER THE NAME OF CONTACT TO SEARCH ");
String verex=sc.nextLine();
int res=admin.display(verex);
if(res==-1)
{
    System.out.println(" CONTACT NOT FOUND ");
}
break;
case 4:
String dr3=sc.nextLine();
admin.display_all();
System.out.println("ENTER THE NAME OF CONTACT FROM LIST TO DISPLAY ");
String verex2=sc.nextLine();
admin.modify(verex2);
admin.sort();
break;
case 5:
System.exit(0);
break;
default :
System.out.println("WRONG INPUT ");
}
}
}
}

    
    
    
            
    
        