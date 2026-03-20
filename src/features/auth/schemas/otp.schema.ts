import z from "zod";

export const otpSchema = z.object({
  otp: z.string().length(6, { message: "Vui lòng nhập mã xác thực!" }),
});
