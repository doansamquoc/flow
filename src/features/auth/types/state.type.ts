export type State =
  | "non-state"
  | "link-sending"
  | "awaiting-link"
  | "sending-otp"
  | "awaiting-otp"
  | "verifying-otp"
  | "expired-otp"
  | "error"
  | "success";
