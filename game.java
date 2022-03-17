/*
PROBLEM STATEMENT
Alice and Bob are playing a game. Both of them have a list of numbers of size n each.
In each turn player can do the following:
    choose a number from their list and add it to score or
    choose a number from opponent's list and remove it from his list


APPROACH
1.sort the lists in descending order(helps in identifying the greatest number present in list)
2.Assign flag=0 for Alice's chance and flag=1 for Bob's chance
3.Calculate sum of each list.
4. If it is Alice's chance and sum of Alice's list is smaller than Bob's list then remove the greatest number from Bob's list.
5. After removing the element decrease the length of Bob's list.
6.Of its Alice's chance and sum of Alice's list is greater than Bob's list then add the greatest number from Alice's list to his score.
7.After adding to score remove that number from ALice's list and update length of his list.
8.change flag=1 to indicate its Bob's chance to play
9. Repeat the same procedure until the length of lists becomes 0


PS: This problem can be solved more conveniently by using ArrayList because removal and length update becomes easier.
 */

public class game {
    public static int sum(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int n=1;
        int alice[]={5};
        int bob[]={3};
        int flag=0;      //flag==0 :Alice   flag==1:Bob
        int score_alice=0;
        int score_bob=0;
        int bob_length=bob.length;
        int alice_length=alice.length;

        for(int i=0;i<n;i++){
            if(alice_length >0 && bob_length>0){
            if(flag==0){
                if(sum(alice)<=sum(bob)){
                    bob[bob_length-1]=0;
                    bob_length=bob_length-1;
                }
                else{
                    score_alice+=alice[alice_length-1];
                    alice[alice_length-1]=0;
                }
                flag=1;
            }
            if(flag==1){
                if(sum(alice)>=sum(bob)){
                    alice[alice_length-1]=0;
                    alice_length=-1;

                }
                else{
                    score_bob+=bob[bob_length-1];
                    bob[bob_length-1]=0;
                }
                flag=0;
            }
        }}
        System.out.println(score_alice-score_bob);
    }
}
