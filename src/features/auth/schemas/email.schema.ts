import z from "zod";

export const emailSchema = z.object({
  email: z.email({ message: "Vui lòng điền địa chỉ email!" }),
});
