export const getErrorMessage = (errorCode: string) => {
  if (errorCode.includes("invalid_credentials"))
    return "Mã xác nhận không đúng!";
};
