/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravigu
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int m_grid;
    private int m_trials;
    private double[] m_percolation_ration;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("invalid inputs");
        }

        m_grid = n;
        m_trials = trials;
        m_percolation_ration = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(m_grid);

            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, m_grid + 1);
                int col = StdRandom.uniform(1, m_grid + 1);
                percolation.open(row, col);
            }
            m_percolation_ration[i] = (double) percolation.numberOfOpenSites() / (m_grid * m_grid);
        }
    }

    public double mean() {
        return StdStats.mean(m_percolation_ration, 0, m_trials);
    }

    public double stddev() {
        return StdStats.stddev(m_percolation_ration);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(m_trials));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(m_trials));
    }

    public static void main(String[] args) {
        int gridSize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(gridSize, trials);
        System.out.println("mean                    =" + stats.mean());
        System.out.println("stddev                  =" + stats.stddev());
        System.out.println("95% confidence level    = [" + stats.confidenceLo()
                + "," + stats.confidenceHi() + "]");

    }
}
