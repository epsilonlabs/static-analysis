# Static Analysis
This repository is built-on the top of Epsilon framework. It supports several languages including:
1. Epsilon Object Language (EOL)
2. Epsilon Validation Language (EVL)
3. Epsilon Transformation Language (ETL)
4. Epsilon Comparison Language (ECL)

Steps to execute static analysis:

1. Download the latest version of Eclipse and select the **Eclipse IDE for Eclipse Committers** option when prompted during the installation process.

2. Clone the Git repository: **git://git.eclipse.org/gitroot/epsilon/org.eclipse.epsilon.git** (**master** branch).

3. Import all the projects under the plugins, features, and tests folders in your workspace.

4. Clone the static analysis git repository: **https://github.com/epsilonlabs/static-analysis.git** (**master** branch)

5. Import all the projects in your workspace.

6. Open **releng/org.eclipse.epsilon.target/org.eclipse.epsilon.target.target** and click the **Set as Active Target Platform** link on the top right

## EOL Example:
1. Open org.eclipse.epsilon.examples.staticanalyser/src/org/eclipse/epsilon/examples/staticanalyser/eol/EolStaticAnalysisStandaloneExample.java.

2. Right-click on **EolStaticAnalysisStandaloneExample.java** in the Project Explorer and select Run as → Java Application.

## EVL Example:
1. org.eclipse.epsilon.examples.staticanalyser/src/org/eclipse/epsilon/examples/staticanalyser/evl/EvlStaticAnalysisStandaloneExample.java.

2. Right-click on **EvlStaticAnalysisStandaloneExample.java** in the Project Explorer and select Run as → Java Application.

## ETL Example:
1. org.eclipse.epsilon.examples.staticanalyser/src/org/eclipse/epsilon/examples/staticanalyser/etl/EtlStaticAnalysisStandaloneExample.java.

2. Right-click on **EtlStaticAnalysisStandaloneExample.java** in the Project Explorer and select Run as → Java Application.

## ECL Example:
1. org.eclipse.epsilon.examples.staticanalyser/src/org/eclipse/epsilon/examples/staticanalyser/ecl/EclStaticAnalysisStandaloneExample.java.

2. Right-click on **EclStaticAnalysisStandaloneExample.java** in the Project Explorer and select Run as → Java Application.
