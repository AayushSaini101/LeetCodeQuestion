class Solution {
 public:  
  ListNode* reverseList(ListNode* head) {
        
        ListNode* currptr=head;
        ListNode* prevptr=NULL;
        ListNode* nextptr;
        
        while(currptr!=NULL){
            nextptr=currptr->next;
            currptr->next=prevptr;
            
            prevptr=currptr;
            currptr=nextptr;
        
        }
        return prevptr;

        
        
    }

    bool isPalindrome(ListNode* head) { 
        if(head==NULL || head->next==NULL){
            return true;
            
        }
        //to find middle of the list
        ListNode* slow=head;
        ListNode* fast=head;
        
        while(fast!=NULL && fast->next!=NULL&&fast->next->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
            
        }
       // cout<<slow->val<<" "<<slow->next->val;
        slow->next=reverseList(slow->next);
        slow=slow->next;
        while(slow!=NULL){
         //   cout<<slow->val<<" "<<head->val<<" ";
            if(head->val!=slow->val)
                return false;
            
            head= head->next;
            slow=slow->next;
        }
        return true;
       
        
        
    }
};