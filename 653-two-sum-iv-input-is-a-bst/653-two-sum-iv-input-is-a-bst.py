# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
  
 def __binarySearch(self, root, k):
    if root is None:
      return

    if root.val == k:
      return root
    elif root.val > k:
      return self.__binarySearch(root.left, k)
    else:
      return self.__binarySearch(root.right, k)

 def __findTargetBST(self, node, root, k):
         
    if node is None:
      return False

    complement = k - node.val
    comp_node = self.__binarySearch(root, complement)
    if comp_node is not None and node is not comp_node:
      return True

    return self.__findTargetBST(node.left, root, k) or self.__findTargetBST(node.right, root, k)

 def findTarget(self, root, k):
    return self.__findTargetBST(root, root, k)
        