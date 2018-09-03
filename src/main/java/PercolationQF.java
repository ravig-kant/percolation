/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravigu
 */
public class PercolationQF {

    private final int[] openSites;
    private final int[] sz;
    private int numOfOpenSites = 0;
    private final int[] connectedComponent;
    private final int gridSize;
    private static final boolean USE_QUICK_FIND = Boolean.valueOf(System.getProperty("useQF"));

    public PercolationQF(int n) {
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
        // Column is subtrated by two. 
        //One for starting indices of array in java. Two the count begins from zero
    }
    
    public void open(int row, int col) throws IllegalArgumentException {
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
        //Always copy the top value to the bottom
        //This will ensure that first index i.e. 0 will be marked for all the
        //full sites. That makes checking wether a site is full or not a constant time operation

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

    public boolean isOpen(int row, int col) throws IllegalArgumentException {
        if (row > gridSize || col > gridSize || row < 1 || col < 1) {
            throw new IllegalArgumentException("Invalid inputs");
        }
        int index = dimensionsToIndices(row, col);
        return isOpen(index);
    }

    private boolean isOpen(int index) {
        return openSites[index] == 0;
    }

    private void union(int first, int second) {
        if (USE_QUICK_FIND) {
            qfUnion(first, second);
        } else {
            qUnion(first, second);
        }
    }

    private void qfUnion(int first, int second) {
        int tmp = connectedComponent[second];
        for (int i = 1; i < gridSize * gridSize + 2; i++) {
            if (connectedComponent[i] == tmp) {
                connectedComponent[i] = connectedComponent[first];
            }
        }
    }

    private int root(int index) {
        if (connectedComponent[index] == index) {
            return index;
        } else {
            return root(connectedComponent[index]);
        }
    }

    private void qUnion(int first, int second) {
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
        if (USE_QUICK_FIND) {
            return isFullQF(index);
        } else {
            return isFullQU(index);
        }
    }

    private boolean isFullQF(int index) {
        return connectedComponent[index] == 0;
    }

    private boolean isFullQU(int index) {
        return root(0) == root(index);
    }

    public boolean percolates() {
        return isFull(gridSize * gridSize + 1);
    }

    public int numOfOpenSites() {
        return numOfOpenSites;
    }

//    private void printConnectedComponents() {
//        System.out.println("Connected components is");
//
//        for (int j = 1; j <= gridSize; j++) {
//            StringBuffer sb = new StringBuffer();
//            sb.append("[");
//            for (int i = ((j - 1) * gridSize) + 1; i <= j * gridSize; i++) {
//                sb.append(openSites[i] + ",");
//            }
//            sb.deleteCharAt(sb.length() - 1);
//            sb.append("]");
//            sb.append("[");
//            for (int i = ((j - 1) * gridSize) + 1; i <= j * gridSize; i++) {
//                sb.append(connectedComponent[i] + ",");
//            }
//            sb.deleteCharAt(sb.length() - 1);
//            sb.append("]");
//            System.out.println(sb.toString());
//        }
//    }

}
