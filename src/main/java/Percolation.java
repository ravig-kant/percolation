/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravigu
 */
public class Percolation {

    private final int[] openSites;
    private final int[] sz;
    private int numOfOpenSites = 0;
    private final int[] connectedComponent;
    private final int gridSize;

    public Percolation(int n) {
        openSites = new int[n * n + 2];
        sz = new int[n * n + 2];
        gridSize = n;
        connectedComponent = new int[n * n + 2];
        for (int i = 0; i < n * n + 2; i++) {
            openSites[i] = 1;
            sz[i] = 1;
            connectedComponent[i] = i;
        }
        openSites[0] = 0;
    }

    private int dimensionsToIndices(int row, int col) {
        return (row - 1) * gridSize + col;
    }
    
    public void open(int row, int col){
        if (row > gridSize || col > gridSize || row < 1 || col < 1) {
            throw new IllegalArgumentException("Invalid inputs");
        }

        int index = dimensionsToIndices(row, col);
        if (isOpen(row, col)) {
            return;
        }

        int top = (row > 1) ? dimensionsToIndices(row - 1, col) : 0;
        int bottom = (row < gridSize) ? dimensionsToIndices(row + 1, col) : gridSize * gridSize + 1;
        int left = (col > 1) ? dimensionsToIndices(row, col - 1) : -1;
        int right = (col < gridSize) ? dimensionsToIndices(row, col + 1) : -1;

        openSites[index] = 0;

        if (left != -1 && isOpen(left)) {
            union(left, index);
        }
        if (right != -1 && isOpen(right)) {
            union(right, index);
        }
        if (isOpen(top)) {
            union(top, index);
        }
        if (isOpen(bottom) || bottom == gridSize * gridSize + 1) {
            union(index, bottom);
        }
        numOfOpenSites++;
    }

    public boolean isOpen(int row, int col) {
        if (row > gridSize || col > gridSize || row < 1 || col < 1) {
            throw new IllegalArgumentException("Invalid inputs");
        }
        int index = dimensionsToIndices(row, col);
        return isOpen(index);
    }

    private boolean isOpen(int index) {
        return openSites[index] == 0;
    }

    private int root(int index) {
        if (connectedComponent[index] == index) {
            return index;
        } else {
            int l_root = root(connectedComponent[index]);
            connectedComponent[index] = l_root;
            return l_root;
        }
    }

    private void union(int first, int second) {
        int rootOfSecond = root(second);
        int rootOfFirst = root(first);

        if (rootOfFirst == rootOfSecond) {
            return;
        }

        if (sz[rootOfFirst] > sz[rootOfSecond]) {
            connectedComponent[rootOfSecond] = rootOfFirst;
            sz[rootOfFirst] += sz[rootOfSecond];
        } else {
            connectedComponent[rootOfFirst] = rootOfSecond;
            sz[rootOfSecond] += sz[rootOfFirst];
        }
    }

    public boolean isFull(int row, int col) {
        if (row > gridSize || col > gridSize || row < 1 || col < 1) {
            throw new IllegalArgumentException("Invalid inputs");
        }
        int index = dimensionsToIndices(row, col);
        return isFull(index);
    }

    private boolean isFull(int index) {
        return root(0) == root(index);
    }

    public boolean percolates() {
        return isFull(gridSize * gridSize + 1);
    }

    public int numberOfOpenSites() {
        return numOfOpenSites;
    }

}
