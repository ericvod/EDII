package ArvoreBinaria;

public class AlgoritmoDSW {
		int makeVine(No grand) {
			  int cnt = 0;
			  var n = grand.dir;
			  while (n != null) {
				if (n.esq != null) {
				  var old_n = n;
				  n = n.esq;
				  old_n.esq = n.dir;
				  n.dir = old_n;
				  grand.dir = n;
				}
				else {      
				    ++cnt;
				    grand = n;
				    n = n.dir;
				}
			  }
			  return cnt;
		}
	
		public void compress(No grand, int m) {
		  var n = grand.dir;
		  while (m-- > 0) {
		    var old_n = n;
		    n = n.dir;
		    grand.dir = n;
		    old_n.dir = n.esq;
		    n.esq = old_n;
		    grand = n;
		    n = n.dir;
		  }
		}
		
		public No balanceBST(No raiz) {
		  No grand = new No(0);
		  grand.esq = raiz;
		  int cnt = makeVine(grand);
		  int m = (int)Math.pow(2, (int)(Math.log(cnt + 1) / Math.log(2))) - 1;
		  compress(grand, cnt - m);
		  for (m = m / 2; m > 0; m /= 2) {
			  compress(grand, m);
		  }
		    
		  return grand.dir;
		}
	
}


