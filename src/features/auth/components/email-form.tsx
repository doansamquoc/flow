import { useForm } from "@tanstack/react-form";
import { emailSchema } from "../schemas/email.schema";
import {
  Field,
  FieldError,
  FieldGroup,
  FieldLabel,
} from "@/components/ui/field";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { ArrowRight } from "lucide-react";
import { Spinner } from "@/components/ui/spinner";

interface EmailFormProps {
  loading: boolean;
  onSubmit(email: string): Promise<void>;
}

const EmailForm = ({ loading, onSubmit }: EmailFormProps) => {
  const form = useForm({
    defaultValues: {
      email: "",
    },
    validators: {
      onSubmit: emailSchema,
    },
    onSubmit: async ({ value }) => {
      await onSubmit(value.email);
    },
  });

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
          name='email'
          children={(field) => {
            const isInvalid =
              field.state.meta.isTouched && !field.state.meta.isValid;
            return (
              <Field data-invalid={isInvalid}>
                <FieldLabel>Email</FieldLabel>
                <Input
                  id={field.name}
                  name={field.name}
                  value={field.state.value}
                  onBlur={field.handleBlur}
                  onChange={(e) => field.handleChange(e.target.value)}
                  aria-invalid={isInvalid}
                  placeholder='Địa chỉ email'
                  autoComplete='email'
                />
                <FieldError errors={field.state.meta.errors} />
              </Field>
            );
          }}
        />
        <Button className='w-full' size={"lg"}>
          {loading ? (
            <Spinner />
          ) : (
            <>
              Gửi mã <ArrowRight />
            </>
          )}
        </Button>
      </FieldGroup>
    </form>
  );
};

export default EmailForm;
