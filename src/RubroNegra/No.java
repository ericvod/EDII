package RubroNegra;

public class No {
	public int v;
	public No p;
	public No esq;
	public No dir;
	public boolean ver;

	public No(int n, boolean ver) {
		this.v = n;
		this.ver = ver;
		this.p = this.esq = this.dir = Arvore.nil;
	}

	public No encontra(int n) {
		if (n < this.v && this.esq != Arvore.nil)
			return this.esq.encontra(n);
		else if (n > this.v && this.dir != Arvore.nil)
			return this.dir.encontra(n);
		else
			return this;
	}

	public No minimo() {
		if (this.esq != Arvore.nil)
			return esq.minimo();
		else
			return this;
	}

	public No maximo() {
		if (this.dir != Arvore.nil)
			return dir.maximo();
		else
			return this;
	}

	public void inorderWalk() {
		if (this.esq != Arvore.nil)
			this.esq.inorderWalk();
		System.out.println(this.v);
		if (this.dir != Arvore.nil)
			this.dir.inorderWalk();
	}

	public No predecessor() {
		if (this.esq != Arvore.nil)
			return this.esq.maximo();
		else
			return this;
	}

	public No sucessor() {
		if (this.dir != Arvore.nil)
			return this.dir.minimo();
		else
			return this;
	}

	public void encontra50(Integer q, int aux, Arvore res) {
		if (q >= 50)
			return;

		if (this.esq != Arvore.nil) {
			this.esq.encontra50(q, aux, res);
		}
		if (this.v > aux && q < 50) {
			res.inserir(this.v);
			q++;
		}
		if (this.dir != Arvore.nil) {
			this.dir.encontra50(q, aux, res);
		}
	}

	public void grafico() {
		if (this.ver) {
			System.out.println("\t" + this.v + " [style = filled, fillcolor = red];");
		} else {
			System.out.println("\t" + this.v + " [style = filled, fillcolor = black, fontcolor = white];");
		}

		if (this.esq != Arvore.nil) {
			System.out.println("\t" + this.v + " -> " + this.esq.v + " [label = \" esq\"];");
			this.esq.grafico();
		} else {
			System.out.println("\t" + this.v + " -> nil [label = \" esq\"];");
		}

		if (this.dir != Arvore.nil) {
			System.out.println("\t" + this.v + " -> " + this.dir.v + " [label = \" dir\"];");
			this.dir.grafico();
		} else {
			System.out.println("\t" + this.v + " -> nil [label = \" dir\"];");
		}
	}
}
