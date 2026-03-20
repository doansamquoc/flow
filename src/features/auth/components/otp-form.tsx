import { useForm } from "@tanstack/react-form";
import { otpSchema } from "../schemas/otp.schema";
import { Button } from "@/components/ui/button";
import {
  Field,
  FieldDescription,
  FieldError,
  FieldGroup,
  FieldLabel,
} from "@/components/ui/field";
import {
  InputOTP,
  InputOTPGroup,
  InputOTPSlot,
} from "@/components/ui/input-otp";
import { REGEXP_ONLY_DIGITS } from "input-otp";
import { ExternalLink } from "lucide-react";
import { useCountdown } from "@/hooks/use-countdown";
import { countdownUtils } from "@/utils/countdown-utils";
import { getErrorMessage } from "../constants/error-message";
const RESEND_SECONDS = Number(import.meta.env.VITE_RESEND_SECONDS ?? 60);

interface OTPFormProps {
  email: string;
  error: string;
  onSubmit(otp: string): Promise<void>;
  onReset(): void;
  onResend(email: string): Promise<void>;
}

const OTPForm = ({
  email,
  error,
  onSubmit,
  onReset,
  onResend,
}: OTPFormProps) => {
  const { countdown, isCounting, restart } = useCountdown(RESEND_SECONDS);

  const form = useForm({
    defaultValues: {
      otp: "",
    },
    validators: {
      onSubmit: otpSchema,
    },
    onSubmit: async ({ value }) => {
      await onSubmit(value.otp);
    },
  });

  async function handleResend() {
    if (isCounting) return;
    await onResend(email);
    restart();
  }

  return (
    <form
      className='w-full'
      onSubmit={(e) => {
        e.preventDefault();
        e.stopPropagation();
        form.handleSubmit();
      }}
    >
      <FieldGroup>
        <form.Field
          name='otp'
          children={(field) => {
            const isInvalid = error !== "";
            return (
              <Field className='w-full'>
                <FieldLabel htmlFor='digits-only'>Nhập mã xác thực</FieldLabel>
                <FieldDescription>
                  Mã xác thực đã được chúng tôi gửi đến địa chỉ email:{" "}
                  <span className='font-bold'>{email}</span> .
                </FieldDescription>
                <InputOTP
                  id={field.name}
                  name={field.name}
                  value={field.state.value}
                  onBlur={field.handleBlur}
                  pattern={REGEXP_ONLY_DIGITS}
                  maxLength={6}
                  onChange={(val) => {
                    field.handleChange(val);
                    if (val.length === 6) {
                      field.handleBlur();
                      form.handleSubmit();
                    }
                  }}
                >
                  <InputOTPGroup className='w-full flex justify-center'>
                    {[0, 1, 2, 3, 4, 5].map((i) => (
                      <InputOTPSlot
                        index={i}
                        key={i}
                        className='w-full h-12'
                        aria-invalid={isInvalid}
                      />
                    ))}
                  </InputOTPGroup>
                </InputOTP>
                {isInvalid && <FieldError>{getErrorMessage(error)}</FieldError>}
              </Field>
            );
          }}
        />
        <div className='flex flex-col gap-2'>
          <Button
            size='lg'
            onClick={() => handleResend()}
            type='button'
            disabled={isCounting}
          >
            {isCounting
              ? `Gửi lại sau ${countdownUtils(countdown)}`
              : "Gửi lại mã xác nhận"}
          </Button>
          <Button
            variant='secondary'
            size='lg'
            onClick={() => onReset()}
            type='button'
            className='relative'
          >
            Dùng email khác <ExternalLink className='absolute right-4' />
          </Button>
        </div>
      </FieldGroup>
    </form>
  );
};

export default OTPForm;
