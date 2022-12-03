package RubroNegra;

public class Arvore {
	public No raiz;

	public static No nil = new No(0, false);
	public Integer cont;

	public Arvore() {
		this.raiz = Arvore.nil;
	}

	public Arvore(int v) {
		this.raiz = new No(v, false);
	}

	public void rotacao_esq(No x) {
		No y = x.dir;
		x.dir = y.esq;
		if (y.esq != Arvore.nil)
			y.esq.p = x;
		y.p = x.p;
		if (x.p == Arvore.nil)
			this.raiz = y;
		else if (x == x.p.esq)
			x.p.esq = y;
		else
			x.p.dir = y;
		y.esq = x;
		x.p = y;
	}

	public void rotacao_dir(No x) {
		No y = x.esq;
		x.esq = y.dir;
		if (y.dir != Arvore.nil)
			y.dir.p = x;
		y.p = x.p;
		if (x.p == Arvore.nil)
			this.raiz = y;
		else if (x == x.p.esq)
			x.p.esq = y;
		else
			x.p.dir = y;
		y.dir = x;
		x.p = y;
	}

	public void inserir(int n) {
		if (this.raiz == Arvore.nil) {
			this.raiz = new No(n, false);
		} else {
			No a = this.encontra(n);
			if (n < a.v) {
				a.esq = new No(n, true);
				a.esq.p = a;
				this.fixaadicao(a.esq);
			} else if (n > a.v) {
				a.dir = new No(n, true);
				a.dir.p = a;
				this.fixaadicao(a.dir);
			}
		}
	}

	public void transplant(No x, No y) {
		if (x.p == Arvore.nil)
			this.raiz = y;
		else if (x == x.p.esq)
			x.p.esq = y;
		else
			x.p.dir = y;
		y.p = x.p;
	}

	private void fixaadicao(No z) {
		No y;
		while (z.p.ver) {
			if (z.p == z.p.p.esq) {
				y = z.p.p.dir;
				if (y.ver) {
					z.p.ver = false;
					y.ver = false;
					z.p.p.ver = true;
					z = z.p.p;
				} else {
					if (z == z.p.dir) {
						z = z.p;
						this.rotacao_esq(z);
					}
					z.p.ver = false;
					z.p.p.ver = true;
					this.rotacao_dir(z.p.p);
				}
			} else {
				y = z.p.p.esq;
				if (y.ver) {
					y.ver = z.p.ver = false;
					z.p.p.ver = true;
					z = z.p.p;
				} else {
					if (z == z.p.esq) {
						z = z.p;
						this.rotacao_dir(z);
					}
					z.p.ver = false;
					z.p.p.ver = true;
					this.rotacao_esq(z.p.p);
				}
			}
		}
		this.raiz.ver = false;
	}

	public void remove(int n) {
		No z = this.encontra(n);
		No x, y = z;
		boolean cordey = y.ver;

		if (z.v == n) {
			if (z.esq == Arvore.nil) {
				x = z.dir;
				this.transplant(z, z.dir);
			} else if (z.dir == Arvore.nil) {
				x = z.esq;
				this.transplant(z, z.esq);
			} else {
				y = z.sucessor();
				cordey = y.ver;
				x = y.dir;

				if (y.p == z)
					x.p = y;
				else {
					this.transplant(y, y.dir);
					y.dir = z.dir;
					y.dir.p = y;
				}
				this.transplant(z, y);
				y.esq = z.esq;
				y.esq.p = y;
				y.ver = z.ver;
			}

			if (!cordey)
				this.fixaremocao(x);
		}
	}

	public void fixaremocao(No n) {
		No x;

		while (n != this.raiz && !n.ver) {
			if (n == n.p.esq) {
				x = n.p.dir;

				if (x.ver) {
					x.ver = false;
					n.p.ver = true;
					this.rotacao_esq(n.p);
					x = n.p.dir;
				}
				if (!x.esq.ver && !x.dir.ver) {
					x.ver = true;
					n = n.p;
				} else {
					if (!x.dir.ver) {
						x.esq.ver = false;
						x.ver = true;
						this.rotacao_dir(x);
						x = n.p.dir;
					}

					x.ver = n.p.ver;
					n.p.ver = false;
					x.dir.ver = false;
					this.rotacao_esq(n.p);
					n = this.raiz;
				}
			} else {
				x = n.p.esq;

				if (x.ver) {
					x.ver = false;
					n.p.ver = true;
					this.rotacao_dir(n.p);
					x = n.p.esq;
				}
				if (!x.esq.ver && !x.dir.ver) {
					x.ver = true;
					n = n.p;
				} else {
					if (!x.esq.ver) {
						x.dir.ver = false;
						x.ver = true;
						this.rotacao_esq(x);
						x = n.p.esq;
					}
					x.ver = n.p.ver;
					n.p.ver = false;
					x.esq.ver = false;
					this.rotacao_dir(n.p);
					n = this.raiz;
				}
			}
		}
		n.ver = false;
	}

	public Arvore encontra50(int n) {
		Arvore res = new Arvore();
		cont = 0;

		this.raiz.encontra50(cont, n, res);

		return res;
	}

	public void inorderWalk() {
		this.raiz.inorderWalk();
	}

	public No minimo() {
		return this.raiz.minimo();
	}

	public No maximo() {
		return this.raiz.maximo();
	}

	public No encontra(int n) {
		return this.raiz.encontra(n);
	}
	
	public void emOrdem(No atual) {
		if (atual != null){
			emOrdem(atual.esq);   
            System.out.printf("%s, ", atual.v);
            emOrdem(atual.dir);
        }
	}
	public void preOrdem(No atual) {
		if (atual != null){
			System.out.printf("%s, ", atual.v);
			preOrdem(atual.esq);   
            preOrdem(atual.dir);
        }
	}
	public void posOrdem(No atual) {
		if (atual != null){
			posOrdem(atual.esq);   
            posOrdem(atual.dir);
            System.out.printf("%s, ", atual.v);
        }
	}
}
