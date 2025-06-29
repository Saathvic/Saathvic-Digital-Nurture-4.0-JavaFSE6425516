
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR rec IN (
    SELECT AccountID, Balance 
    FROM Accounts1 
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts1
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountID = rec.AccountID;
  END LOOP;
END;
/


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_Department IN VARCHAR2,
  p_BonusPercent IN NUMBER
) IS
BEGIN
  UPDATE Employees2
  SET Salary = Salary + (Salary * p_BonusPercent / 100)
  WHERE Department = p_Department;
END;
/


CREATE OR REPLACE PROCEDURE TransferFunds (
  p_SourceAccountID IN INT,
  p_TargetAccountID IN INT,
  p_Amount IN INT
) IS
  v_SourceBalance INT;
BEGIN

  SELECT Balance INTO v_SourceBalance 
  FROM Accounts1 
  WHERE AccountID = p_SourceAccountID FOR UPDATE;

 
  IF v_SourceBalance >= p_Amount THEN
   
    UPDATE Accounts1
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_SourceAccountID;

  
    UPDATE Accounts1
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_TargetAccountID;

    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient funds. Transfer failed.');
  END IF;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('One of the accounts does not exist.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/


BEGIN
  ProcessMonthlyInterest;
  UpdateEmployeeBonus('IT', 10);
  TransferFunds(1, 2, 300);
END;
/


SELECT * FROM Accounts1;
SELECT * FROM Employees2;
