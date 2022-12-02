package ArvoreBinaria;

public class No {
	long info;
	No dir;
	No esq;
	
	public No() {
	}
	
	public No(long info) {
		this.info = info;
		this.dir = null;
		this.esq = null;
	}

	public long getInfo() {
		return info;
	}

	public void setInfo(long info) {
		this.info = info;
	}

	public No getDir() {
		return dir;
	}

	public void setDir(No dir) {
		this.dir = dir;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}
}
