package ArvoreBinaria;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Arvore {
	ArrayList<Object> vetor = new ArrayList<Object>();
	No raiz;
	
	Arvore(){
		raiz = null;
	}
	
	public void inserir(long info) {
	    No novo = new No(info); 

	    if (raiz == null) {
	    	raiz = novo;
	    }else {
	      No atual = raiz;
	      No anterior;
	      while(true) {
	        anterior = atual;
	        if (info <= atual.info) {
	          atual = atual.esq;
	          if (atual == null) {
	            anterior.esq = novo;
	            return;
	          } 
	        }
	        else {
	           atual = atual.dir;
	           if (atual == null) {
	             anterior.dir = novo;
	             return;
	           }
	        } 
	      }
	    }
	 }
	
	public No buscar(long info) {
	    if (raiz == null) {
	    	return null;
	    }
	    No atual = raiz;
	    while (atual.info != info) {
	      if(info < atual.info ) {
	    	  atual = atual.esq;
	      }else {
	    	  atual = atual.dir; 
	      }
	      if (atual == null) {
	    	  return null;
	      }
	    }
	    return atual;
	  }
	
	public boolean remover(long v) {
	    if (raiz == null) {
	    	return false;
	    }

	    No atual = raiz;
	    No pai = raiz;
	    boolean filho_esq = true;

	    while (atual.info != v) {
	    	pai = atual;
	    	if(v < atual.info ) {
	    		atual = atual.esq;
	    		filho_esq = true;
	    	} else { 
	    		atual = atual.dir; 
	        	filho_esq = false; 
	    	}
	    	if (atual == null) {
	    		return false;
	    	}
	    } 
	   
	    if (atual.esq == null && atual.dir == null) {
	      if (atual == raiz ) {
	    	  raiz = null; 
	      }
	      else if (filho_esq) {
	    	  pai.esq = null;
	      }
	           else {
	        	   pai.dir = null; 
	           }
	    }

	    else if (atual.dir == null) {
	       if (atual == raiz) {
	    	   raiz = atual.esq;
	       }
	       else if (filho_esq) pai.esq = atual.esq; 
	            else pai.dir = atual.esq;
	    }
	    else if (atual.esq == null) {
	       if (atual == raiz) {
	    	   raiz = atual.dir;
	       }
	       else if (filho_esq) pai.esq = atual.dir;
	            else pai.dir = atual.dir;
	    }
	    else {
	      No sucessor = atual;
	     
	      if (atual == raiz) {
	    	  raiz = sucessor;
	      }
	      else if(filho_esq) pai.esq = sucessor; 
	           else pai.dir = sucessor; 
	      sucessor.esq = atual.esq;   
	    }
	    return true;
	  }
	
	public void emOrdem(No atual){
        if (atual != null){
            emOrdem(atual.getEsq());
            vetor.add((int)atual.getInfo());
            emOrdem(atual.getDir());
        }        
    }
	public void preOrdem(No atual){
        if (atual != null){
            System.out.printf("%s, ", atual.getInfo());
            preOrdem(atual.getEsq());            
            preOrdem(atual.getDir());
        }        
    }
    
    public void posOrdem(No atual){
        if (atual != null){            
            posOrdem(atual.getEsq());            
            posOrdem(atual.getDir());
            System.out.printf("%s, ", atual.getInfo());
        }        
    }
    public void emNivel(No raiz){
    	Deque<No> fila = new ArrayDeque<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            No atual = fila.removeFirst();
            System.out.printf("%s, ", atual.getInfo());
            if (atual.getEsq() != null) {
            	fila.add(atual.getEsq());
            }
            if (atual.getDir() != null) {
            	fila.add(atual.getDir());
            }
        }
    }
}
