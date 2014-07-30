node              current node
 FOUND;
 NOT_FOUND;
 g                 the cost to reach current node(root..node)
 f                 estimated cost of the cheapest path (root..node..goal)
 h(node)           estimated cost of the cheapest path (node..goal)
 cost(node, succ)  path cost function
 is_goal(node)     goal test
 successors(node)  node expanding function
 int min ;




 procedure ida_star(root, cost(), is_goal(), h()){
   bound = h(root);
   while(true){
     t = search(root, 0, bound);
     if (t == FOUND) return FOUND;
     if (t == ∞) return NOT_FOUND;
     bound = t ;
   }

 }


 function search(node, g, bound){
   f = g + h(node)
   if f > bound then return f
   if is_goal(node) then return FOUND
   min = ∞
   for succ in successors(node) do
     t = search(succ, g + cost(node, succ), bound)
     if (t == FOUND) return FOUND;
     if (t < min) min = t;
   end for
   return min;
 }
