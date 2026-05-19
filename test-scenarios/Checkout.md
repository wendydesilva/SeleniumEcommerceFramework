

|Test Case ID|Scenario|Preconditions|Test Data|Steps|Expected Results|
|-|-|-|-|-|-|
|TC01|Valid Checkout Flow|N/A|First Name: Wendy<br />Last Name: De Silva<br />Zip Code: V3A6R4|1: Add item<br />2. Go to cart<br />3. Click Checkout<br />4.Enter First Name, Last Name, Zip Code<br />5. Click Continue|User proceeds to overview page|
|TC02|Empty First Name|N/A|Last Name: De Silva<br />Zip Code: V3A6R4|1: Add item<br />2. Go to cart<br />3. Click Checkout<br />4. Enter Only Last Name, Zip Code<br />5. Click Continue|Displays Error Message "Error: First Name is required"|
|TC03|Empty Last Name|N/A|First Name: Wendy<br />Zip Code: V3A6R4|1: Add item<br />2. Go to cart<br />3. Click Checkout<br />4. Enter Only First Name, Zip Code<br />5. Click Continue|Displays Error Message "Error: Last Name is required"|
|TC04|Empty Postal Code|N/A|First Name: Wendy<br />Last Name: De Silva<br />|1: Add item<br />2. Go to cart<br />3. Click Checkout<br />4. Enter Only First Name, Last name<br />5. Click Continue|Displays Error Message "Error: Postal Code is required"|



