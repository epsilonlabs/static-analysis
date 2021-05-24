# Static Analysis
This repository is built-on the top of Epsilon framework. It supports several languages including:
1. Epsilon Object Language (EOL)
2. Epsilon Validation Language (EVL)
3. Epsilon Transformation Language (ETL)

Steps to execute static analysis:

1. Download the latest version of Eclipse and select the **Eclipse IDE for Eclipse Committers** option when prompted during the installation process.

2. Clone the Git repository: **git://git.eclipse.org/gitroot/epsilon/org.eclipse.epsilon.git** (**sq-staticanalysis** branch).

3. Import all the projects under the plugins, features, and tests folders in your workspace.

4. Clone the static analysis git repository: **https://github.com/epsilonlabs/static-analysis.git** (**master** branch)

5. Import all the projects in your workspace.

6. Open **releng/org.eclipse.epsilon.target/org.eclipse.epsilon.target.target** and click the **Set as Active Target Platform** link on the top right

## ETL Example:
8. Open org.eclipse.epsilon.etl.staticanalyser/src/org/eclipse/epsilon/etl/example/staticanalyser/EtlStaticAnalysisStandaloneExample.java.

9. Right-click on **EtlStaticAnalysisStandaloneExample.java** in the Project Explorer and select Run as → Java Application.
