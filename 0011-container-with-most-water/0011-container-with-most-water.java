class Solution {
    public int maxArea(int[] height) {
        

int left=0;
int right=height.length-1;
int maxnum=0;
while(left<right)
{
    int w=right-left;
    int cm=Math.min(height[right],height[left]);

    int area=w*cm;
    maxnum=Math.max(area,maxnum);

    if(height[right]<height[left])
    {
        right--;
    }
    else
    {
        left++;
    }
}

return maxnum;
      


    }
}