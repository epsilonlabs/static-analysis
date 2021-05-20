# Static Analysis
This repository is built-on the top of Epsilon framework. It supports several languages including:
1. Epsilon Object Language (EOL)
2. Epsilon Validation Language (EVL)
3. Epsilon Transformation Language (ETL)

Steps to apply static analysis:

1. Source code of Epsilon shall be cloned from the following git repository:
  
  **git://git.eclipse.org/gitroot/epsilon/org.eclipse.epsilon.git**

-Checkout **sq-staticanalysis** branch

2. Clone static analysis repository:

https://github.com/epsilonlabs/static-analysis.git (**master** branch)

3. Import both 1 and 2 repositories plugins in eclipse workspace to use static analysis

4. Set **org.eclipse.epsilon.target.target** as active target platform

## ETL Static Analysis

-Run **EtlStaticAnalysisStandaloneExample** as Java Application to run the example for static analysis on standalone ETL program
